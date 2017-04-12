package com.sandbox.protobuf;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;

public class Serialization implements SerializationMechanism {

	private static final Logger logger = LoggerFactory
			.getLogger(Serialization.class);

	@Override
	public void readFile(Timer totalTimer, Timer timer, String filename, boolean print)
			throws IOException {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(filename)));
			Context totalCtx = totalTimer.time();
			Context ctx = timer.time();
			List<SerialEntry> entries = (List<SerialEntry>) objIn.readObject();
			ctx.stop();
			totalCtx.stop();
			objIn.close();
			if (print) {
				for (SerialEntry e : entries) {
					logger.debug(e.getKey() + "=" + e.getValue());
				}
			}
		} catch (ClassNotFoundException ce) {
			logger.error("error while deserializing", ce);
		}
	}

	@Override
	public void writeToFile(Timer totalTimer, Timer timer, String filename, int size)
			throws IOException {
		List<SerialEntry> entries = ListGenerator.generateSerialEntries(size);
		ObjectOutputStream objOut = new ObjectOutputStream(
				new FileOutputStream(filename));
		Context totalCtx = totalTimer.time();
		Context ctx = timer.time();
		objOut.writeObject(entries);
		ctx.stop();
		totalCtx.stop();
		objOut.close();
	}

}
