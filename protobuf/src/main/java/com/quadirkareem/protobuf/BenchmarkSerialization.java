package com.quadirkareem.protobuf;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.codahale.metrics.Timer;

public class BenchmarkSerialization {

	private static final Logger logger = LoggerFactory
			.getLogger(BenchmarkSerialization.class);
	private static String protostufffile = "src/main/resources/protostuff.dat";
	private static String protostuffv2file = "src/main/resources/protostuffv2.dat";
	private static String protobuffile = "src/main/resources/protobuf.dat";
	private static String serialfile = "src/main/resources/serial.dat";
	private static String externfile = "src/main/resources/extern.dat";
	
	private static final MetricRegistry metrics = new MetricRegistry();
	private static final Slf4jReporter reporter = Slf4jReporter
			.forRegistry(metrics).outputTo(logger)
			.convertRatesTo(TimeUnit.SECONDS)
			.convertDurationsTo(TimeUnit.MILLISECONDS).build();
	private static final Timer protostuffTotalTimer = metrics
			.timer("protostuffTotalTimer");
	private static final Timer protostuffWriteTimer = metrics
			.timer("protostuffWriteTimer");
	private static final Timer protostuffReadTimer = metrics.timer("protostuffReadTimer");

	private static final Timer protostuffV2TotalTimer = metrics
			.timer("protostuffV2TotalTimer");
	private static final Timer protostuffV2WriteTimer = metrics
			.timer("protostuffV2WriteTimer");
	private static final Timer protostuffV2ReadTimer = metrics.timer("protostuffV2ReadTimer");

	private static final Timer protobufTotalTimer = metrics
			.timer("protobufTotalTimer");
	private static final Timer protobufWriteTimer = metrics
			.timer("protobufWriteTimer");
	private static final Timer protobufReadTimer = metrics.timer("protobufReadTimer");

	private static final Timer serialTotalTimer = metrics
			.timer("serialTotalTimer");
	private static final Timer serialWriteTimer = metrics
			.timer("serialWriteTimer");
	private static final Timer serialReadTimer = metrics
			.timer("serialReadTimer");

	private static final Timer externTotalTimer = metrics
			.timer("externTotalTimer");
	private static final Timer externWriteTimer = metrics
			.timer("externWriteTimer");
	private static final Timer externReadTimer = metrics
			.timer("externReadTimer");
	
	private static final int SIZE = 1000;
	private static final int LOOP = 1000;
	private static final boolean PRINT = false;

	public static void main(String[] args) throws IOException,
			InterruptedException {
		reporter.start(5, TimeUnit.SECONDS);
		
		for(int i=0; i < LOOP; i++) {
			protobuf();
		}		
		for(int i=0; i < LOOP; i++) {
			protostuff();
		}
		for(int i=0; i < LOOP; i++) {
			protostuffv2();
		}
		for(int i=0; i < LOOP; i++) {
			srl();
		}
		for(int i=0; i < LOOP; i++) {
			xtrn();
		}
		
		if(!PRINT) {
			Thread.sleep(5000);
		}
	}
	
	private static void protobuf() throws IOException {
		Protobuf pbuf = new Protobuf();
		pbuf.writeToFile(protobufTotalTimer, protobufWriteTimer, protobuffile, SIZE);
		pbuf.readFile(protobufTotalTimer, protobufReadTimer, protobuffile, PRINT);		
	}
	
	private static void protostuff() throws IOException {
		Protostuff pstuff = new Protostuff();
		pstuff.writeToFile(protostuffTotalTimer, protostuffWriteTimer, protostufffile, SIZE);
		pstuff.readFile(protostuffTotalTimer, protostuffReadTimer, protostufffile, PRINT);		
	}
	
	private static void protostuffv2() throws IOException {
		Protostuff pstuff = new Protostuff();
		pstuff.writeToFile(protostuffV2TotalTimer, protostuffV2WriteTimer, protostuffv2file, SIZE);
		pstuff.readFile(protostuffV2TotalTimer, protostuffV2ReadTimer, protostuffv2file, PRINT);		
	}
	
	private static void srl() throws IOException {
		Serialization serial = new Serialization();
		serial.writeToFile(serialTotalTimer, serialWriteTimer, serialfile, SIZE);
		serial.readFile(serialTotalTimer, serialReadTimer, serialfile, PRINT);
	}
	
	private static void xtrn() throws IOException {
		Externalization extrn = new Externalization();
		extrn.writeToFile(externTotalTimer, externWriteTimer, externfile, SIZE);
		extrn.readFile(externTotalTimer, externReadTimer, externfile, PRINT);
	}

}
