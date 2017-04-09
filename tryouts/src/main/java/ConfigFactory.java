package com.ciphercloud.automation.core.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.yaml.snakeyaml.Yaml;

public class ConfigFactory {
	private static StrSubstitutor substitutor;
	
	static {
		init();
	}
	
	public static <T> T getConfig(String configFilePath, Class<T> clazz)
			throws IOException {
		Yaml yaml = new Yaml();
		return (T) yaml.loadAs(getInterpolatedString(configFilePath), clazz);
	}
	
	private static String getInterpolatedString(String filePath) throws IOException {
		String yamlString = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
		return substitutor.replace(yamlString);
	}

	private static void init() {
		substitutor = new StrSubstitutor(getGlobalEnv());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Map<String, String> getGlobalEnv() {
		Map<String, String> globalEnv = new HashMap<String, String>();
		globalEnv.putAll(System.getenv());
		Map<String, String> systemProperties = (Map) System.getProperties();
		globalEnv.putAll(systemProperties);
		return globalEnv;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getConfig2(String filePath, Class clazz)
			throws IOException {
		Yaml yaml = new Yaml();
		T config = (T) yaml.loadAs(
				Files.newBufferedReader(Paths.get(filePath)), clazz);
		T configProxy = (T) SubstitutionInterceptor.newInstance(clazz, config);
		
		return configProxy;
	}
	
}
