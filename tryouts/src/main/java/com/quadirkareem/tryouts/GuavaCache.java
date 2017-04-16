package com.quadirkareem.tryouts;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public class GuavaCache {
	private static final Logger logger = LoggerFactory
			.getLogger(GuavaCache.class);

	private LoadingCache<String, String> localCache;

	public GuavaCache() {
		RemovalListener<String, String> removalListener = new RemovalListener<String, String>() {
			public void onRemoval(RemovalNotification<String, String> removal) {
				logger.debug("Removed: key = {}, value = {}", removal.getKey(),
						removal.getValue());
			}
		};

		localCache = CacheBuilder.from("maximumSize=1000")
				.removalListener(removalListener)
				.recordStats()
				.build(new CacheLoader<String, String>() {
					public String load(String key)
							throws InvalidCacheLoadException {
						String value = String.valueOf(System.currentTimeMillis());
						logger.debug("load: key = {}, value = {}", key, value);
						return value;
					}
				});
	}

	public void put(String key, String value) {
		localCache.put(key, value);
	}

	public String get(String key) {
		String value = null;
		try {
			value = (String) localCache.get(key);
		} catch (ExecutionException e) {
			// key does not exist either in local or in hazelcast
			// its ok not to log it as error
			logger.debug("Key {} not in local cache", key);
		}
		return value;
	}
	
	public void logStats() {
		CacheStats stats = localCache.stats();
		logger.debug("stats = {}", stats.toString());
//		localCache.invalidateAll();
//		logSize();
	}
	
	public void logSize() {
		logger.debug("cache size = {}", localCache.size());
	}

	public void cleanup() {
		localCache.cleanUp();
	}
}
