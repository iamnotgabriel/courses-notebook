package start;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import types.PosInvoice;

import java.util.ArrayList;
import java.util.Arrays;

public class DispatcherManager {

    private static Logger logger = LogManager.getLogger();
    private final String topic;
    private final KafkaProducer<Integer, PosInvoice> producer;

    private final ArrayList<Thread> threads;

    private final int maxWorkers;

    public DispatcherManager(KafkaProducer<Integer, PosInvoice> producer, String topic, int maxWorkers) {
        this.producer = producer;
        this.topic = topic;
        this.threads = new ArrayList<>(maxWorkers);
        this.maxWorkers = maxWorkers;
    }


    public void dispatch(final PosInvoice[] invoices) {
        final int sectionSize = invoices.length / maxWorkers + invoices.length % 2;
        int sectionStart = 0;
        logger.info("dispatching " + invoices.length + " invoices in chunks of size " +  sectionSize);
        for(int i = 0; i < maxWorkers; i++) {
            int sectionEnd  = Math.min(invoices.length, sectionStart+sectionSize);
            PosInvoice[] section = Arrays.copyOfRange(invoices, sectionStart, sectionEnd);
            logger.info("dispatching thread " +  i + " with " +section.length+ " invoices to " + topic);
            sectionStart += sectionSize;
            Thread thread = new Thread(new Dispatcher(producer, topic, section));
            threads.add(i, thread);
            thread.start();
        }

        join();
    }

    public void join() {
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
