package start;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import types.PosInvoice;

import java.util.concurrent.Future;

public class Dispatcher implements Runnable {
    private static final Logger logger = LogManager.getLogger();
    private final String topic;
    private final PosInvoice[] posInvoices;
    private final KafkaProducer<Integer, PosInvoice> producer;

    public Dispatcher(KafkaProducer<Integer, PosInvoice> producer, String topic, PosInvoice[]  posInvoices) {
        this.topic = topic;
        this.producer = producer;
        this.posInvoices = posInvoices;
    }

    @Override
    @SuppressWarnings({})
    public void run() {
        int i = 0;

        for(PosInvoice posInvoice : posInvoices) {
            logger.info(this.toString() + " is sending message #" + (i + 1) + " to topic " + topic);
            Future<RecordMetadata> future = producer.send(new ProducerRecord<>(topic, ++i, posInvoice));
            while(!future.isDone());
            try {
                RecordMetadata  record = future.get();
                logger.info("topic: "+ record.topic()+ " partition: " +  record.partition()+ " offset " + record.offset());
            } catch (Exception e) {
                throw  new RuntimeException(e);
            }

        }
    }
}
