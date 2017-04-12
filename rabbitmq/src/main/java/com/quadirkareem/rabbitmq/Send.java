package com.quadirkareem.rabbitmq;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	private final static String QUEUE_NAME = "welcome";

	private static final int COUNT = 100000;

	private static final String DATA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	private static Random rand = new Random();

	public static void main(String[] argv) throws java.io.IOException, java.util.concurrent.TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("172.16.13.24");
		factory.setUsername("admin");
		factory.setPassword("admin");
		factory.setVirtualHost("/");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		String message = getRandStr(1024);
		System.out.println("Message Is " + message);

		BasicProperties props = new BasicProperties.Builder().deliveryMode(2).build();
		long startTime = System.nanoTime();

		for (int i = 0; i < COUNT; i++) {
			channel.basicPublish("", QUEUE_NAME, props, message.getBytes());
		}
		long endTime = System.nanoTime();

		long diff = endTime - startTime;

		long durationNanos = endTime - startTime;
		long durationMillis = TimeUnit.NANOSECONDS.toMillis(durationNanos);
		double throughput = COUNT / durationMillis;
		System.out.println("Total Messages Sent: " + COUNT);
		System.out.println("Total Time taken: " + durationMillis + " ms");
		System.out.println("Throughput: " + throughput + " msgs/ms");
	}

	public static String getRandStr(int size) {

		StringBuffer sb = new StringBuffer();
		int index = 0;

		for (int i = 0; i < size; i++) {

			index = rand.nextInt(DATA.length());

			sb.append(DATA.charAt(index));
		}

		return sb.toString();
	}

}
