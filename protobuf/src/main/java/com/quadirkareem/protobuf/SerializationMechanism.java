package com.quadirkareem.protobuf;

import java.io.IOException;

import com.codahale.metrics.Timer;

public interface SerializationMechanism {

	public void readFile(Timer totalTimer, Timer timer, String filename, boolean print) throws IOException;
	
	public void writeToFile(Timer totalTimer, Timer timer, String filename, int size) throws IOException;
	
}
