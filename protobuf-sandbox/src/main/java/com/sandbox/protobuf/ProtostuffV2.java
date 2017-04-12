package com.sandbox.protobuf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import com.sandbox.protobuf.protostuff.types.Entry;
import com.sandbox.protobuf.protostuff.types.EntryList;

public class ProtostuffV2 implements SerializationMechanism {
	private static final Logger logger = LoggerFactory
			.getLogger(ProtostuffV2.class);

	private LinkedBuffer buffer = LinkedBuffer.allocate(819200);

	public void readFile(Timer totalTimer, Timer timer, String filename, boolean print)
			throws IOException {
		try {
			EntryList entries = new EntryList();
			FileInputStream fileIn = new FileInputStream(filename);
			Context totalCtx = totalTimer.time();
			Context ctx = timer.time();
			ProtobufIOUtil.mergeFrom(fileIn, entries,
					EntryList.getSchema());
			ctx.stop();
			totalCtx.stop();
			fileIn.close();
			if (print) {
				for (Entry e : entries.getEntryList()) {
					logger.debug(e.getKey() + "=" + e.getValue());
				}
			}
		} finally {
			buffer.clear();
		}
	}

	public void writeToFile(Timer totalTimer, Timer timer, String filename, int size)
			throws IOException {
		EntryList entries = ListGenerator.generateProtostuffEntriesV2(size);
		FileOutputStream fileOut = new FileOutputStream(filename);
		Context totalCtx = totalTimer.time();
		Context ctx = timer.time();
		ProtobufIOUtil.writeTo(fileOut, entries, EntryList.getSchema(), buffer);
		ctx.stop();
		totalCtx.stop();
		fileOut.close();
	}

}
