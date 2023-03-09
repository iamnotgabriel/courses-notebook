package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Scanner;

public class Dispatcher implements Runnable {
    private static int instances = 0;
    private final KafkaProducer<Integer, String> producer;
    private final String topic;
    private final Scanner file;

    private final int instanceId;

    Dispatcher(KafkaProducer<Integer, String> producer, String topic, Scanner file) {
        this.producer = producer;
        this.topic = topic;
        this.file = file;
        this.instanceId = ++instances;
    }

    @Override
    public void run() {
        for (int i = 0; file.hasNextLine(); i++) {
            String line  = file.nextLine();
            producer.send(new ProducerRecord<>(topic, i, line));
        }
    }
}
