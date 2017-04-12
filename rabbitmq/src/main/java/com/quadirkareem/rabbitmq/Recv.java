package com.quadirkareem.rabbitmq;

import java.util.concurrent.TimeUnit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Recv {

	private final static String QUEUE_NAME = "welcome";

	private static final int COUNT = 100000;

	private static int IN_PROGRESS = 0;

	public static void main(String[] argv) throws java.io.IOException,
                        java.util.concurrent.TimeoutException,
			java.lang.InterruptedException {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("172.16.13.24");
		factory.setUsername("admin");
		factory.setPassword("admin");
		factory.setVirtualHost("/");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);

		long startTime = 0L;

		long endTime = 0L;

		while (true) {
			if (IN_PROGRESS == 0) {
				startTime = System.nanoTime();
			}
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			IN_PROGRESS++;
			// System.out.println(" [x] Received '" + message + "'");
			if (IN_PROGRESS == COUNT) {
				endTime = System.nanoTime();
				IN_PROGRESS = 0;
				System.out.println(" Time to process " + COUNT
						+ " messages is "
						+ TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
			}
		}

	}
}
