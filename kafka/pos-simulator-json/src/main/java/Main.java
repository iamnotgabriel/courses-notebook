import data_generator.InvoiceGenerator;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import serde.JsonSerializer;
import start.DispatcherManager;
import types.PosInvoice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "pos-simulator-json");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


        KafkaProducer<Integer, PosInvoice> producer = new KafkaProducer<>(props);
        InvoiceGenerator generator = new InvoiceGenerator();
        PosInvoice[] invoices = {
                generator.getNextInvoice(),
                generator.getNextInvoice(),
                generator.getNextInvoice(),
                generator.getNextInvoice(),
                generator.getNextInvoice(),
                generator.getNextInvoice(),
                generator.getNextInvoice(),
                generator.getNextInvoice(),
                generator.getNextInvoice(),
                generator.getNextInvoice(),
                generator.getNextInvoice(),
                generator.getNextInvoice(),
        };

        DispatcherManager manager = new DispatcherManager(producer, "pos-simulator", 2);
        manager.dispatch(invoices);
        Future<RecordMetadata> future = producer.send(new ProducerRecord<>("pos-simulator", 1, invoices[0]));
    }
}
