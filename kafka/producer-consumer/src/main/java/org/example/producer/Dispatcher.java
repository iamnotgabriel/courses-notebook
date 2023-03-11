package org.example.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.example.KafkaConfig;
import org.example.domain.DeliveryAddress;
import org.example.domain.DeliveryAddressGenerator;

import java.util.Properties;

public class Dispatcher extends Thread {
    private final int batchSize;
    private final int timeout;

    private final Properties props;


    public Dispatcher(Properties props, int batchSize, int timeout) {
        this.props = props;
        this.batchSize = batchSize;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        KafkaProducer<String, DeliveryAddress> producer = new KafkaProducer<>(props);
        System.out.println("running dispatcher thread");
        int i  = 0;
        while(i < 3) {
            DeliveryAddress[] addresses = generateAddresses();
            for(DeliveryAddress address: addresses) {
                System.out.println("[producer] sending address: " +  address.getAddressLine() + " - " + address.getPinCode());
                producer.send(new ProducerRecord<>(KafkaConfig.topic, address.getPinCode().toString(), address));
            }
            trySleep();
            i++;
        }
    }

    private DeliveryAddress[] generateAddresses() {
        DeliveryAddressGenerator generator = new DeliveryAddressGenerator();
        DeliveryAddress[]  addresses = new DeliveryAddress[batchSize];
        for(int i =0; i< batchSize; i++) {
            addresses[i]  = generator.next();
        }

        return addresses;
    }

    private void trySleep() {
        try {
            Thread.sleep(timeout);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
