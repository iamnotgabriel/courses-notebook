package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    static final String topic = "hello-producer";
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("kafka.properties"));
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        File[] files = new File[]{new File("data/user-table-1.csv"), new File("data/user-table-2.csv")};
        Thread[] threads = new Thread[files.length];
        KafkaProducer<Integer, String> producer = new KafkaProducer<>(props);

        for (int i = 0; i < threads.length; i++) {
            Scanner scanner = new Scanner(files[i]);
            threads[i] = new Thread(new Dispatcher(producer, topic, scanner));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        producer.close();
    }
}