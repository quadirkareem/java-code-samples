package com.sandbox.protobuf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;
import com.sandbox.protobuf.protobuf.types.EntryProtos;

public class Protobuf implements SerializationMechanism {
	private static final Logger logger = LoggerFactory
			.getLogger(Protobuf.class);

	public void readFile(Timer totalTimer, Timer timer, String filename, boolean print)
			throws IOException {
		FileInputStream fileIn = new FileInputStream(filename);
		Context totalCtx = totalTimer.time();
		Context ctx = timer.time();
		EntryProtos.EntryList entries = EntryProtos.EntryList.parseFrom(fileIn);
		ctx.stop();
		totalCtx.stop();
		fileIn.close();
		if (print) {
			for (EntryProtos.Entry e : entries.getEntryList()) {
				logger.debug(e.getKey() + "=" + e.getValue());
			}
		}

	}

	public void writeToFile(Timer totalTimer, Timer timer, String filename, int size)
			throws IOException {
		EntryProtos.EntryList entries = ListGenerator
				.generateProtobufEntries(size);
		FileOutputStream fileOut = new FileOutputStream(filename);
		Context totalCtx = totalTimer.time();
		Context ctx = timer.time();
		entries.writeTo(fileOut);
		ctx.stop();
		totalCtx.stop();
		fileOut.close();
	}

}
