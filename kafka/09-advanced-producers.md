# Advanced Producers
How to scale up producers ? Kafka producers are thread safe (Java). To scale
up, just create X threads to send messages using the same object. Do not
instantiate more than one object per program, as the Kafka producer will create
more buffers and another I/O thread.

## At Most One vs. At Least One
Kafka is 'At least one' by default. This means that if the message is saved to
the broker and a network problem occurs, then the producer will try to save the
message again until it receives the confirmation back. Every message is saved
At least once.
In a at most one strategy, duplication can never happen so every message is
saved at most once, the down side is that if a message fails to be saved the 
producer will not try to send again, because this method is set by zeroing the
retry count of the producer.
 

# Exactly once
To make sure the message is always saved and without any message loss, enable
idempotence with `enable.idempotence=true`. The producer will receive a unique
id from the broker and the each message will receive a sequence number from 
zero up. 
With the id and sequence number of messages, the broker knows when a message
was duplicated by the retries. This strategy do not block application level
duplicated, when the application sends the message twice.
