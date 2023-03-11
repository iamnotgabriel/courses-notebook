package org.example.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.example.KafkaConfig;
import org.example.domain.DeliveryAddress;

import java.util.Arrays;
import java.util.Properties;

public class Receiver extends Thread {
    private static final String prefix = "[consumer] ";
    private final Properties props;

    public Receiver(Properties props) {
        this.props = props;
    }

    @Override
    public void run() {
        KafkaConsumer<String, DeliveryAddress> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(KafkaConfig.topic));
        System.out.println("running receiver thread");
        while(true) {
            ConsumerRecords<String, DeliveryAddress> records = consumer.poll(500);
            for(ConsumerRecord<String, DeliveryAddress> record: records) {
                System.out.println(prefix + "received address in topic " + record.topic());
                printAddress(record.value());
                System.out.println();
            }
        }
    }

    private void printAddress(DeliveryAddress address) {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix + "address line: " +address.getAddressLine() + "\n");
        builder.append(prefix + "city: " +address.getCity() + "\n");
        builder.append(prefix + "state: " +address.getState() + "\n");
        builder.append(prefix + "pin code: " +address.getPinCode() + "\n");
        builder.append(prefix + "contact number: " +address.getContactNumber() + "\n");
        System.out.println(builder.toString());
    }
}
