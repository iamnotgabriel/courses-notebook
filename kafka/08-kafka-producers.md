# Java Producer APIs
## Problem
Create the simplest possible Kafka producer to send messages to topic

## Solution
Kafka Producer API 

## Producer API
Configure the producer adding the address of the broker, the identifier of the
application, the serializers used in for key and value of the message.

Send messages to a topic wrapping the value in the ProducerRecord. Every
message has a key and value.

Always close kafka producer connection after sending messages!

### ProducerRecord
Contains all data of the message:
1. Topic*: target topic of the message
2. MessageValue*: content of the message
3. Partition: Which partition the message will be sent
4. MessageKey: key of the value pair of the message (consider it mandatory)
5. Timestamp: when the message was sent

### ProducerSerializer
Convert the value of the key and value to array of bytes.
Every message follows this path before it is send to the broker:
1. Serialization
2. Partitioning
3. Stored in a buffer

## ProducerPartitioning
The producer can choose which partition can be used, and can set a custom
strategy to partition messages. This is not very used, most often the Default
Partitioner is good enough. The Default Partitioner follows one of the two
strategies: Round robin, or Hash Key partitioning
The Hash strategy can be used to always messages to the same partition using
the same key. The hash also takes the number of partitions into account adding
partitions to topic would change the partition of a given key.
The Round robin is used when the message is null (to equally distribute 
messages) in the partitions. 

### Timestamp
Timestamp of the message can be set with two strategies:
0. Create Time: producer sets the timestamp (default)
1. Append Log Time: broker overwrites the producer timestamp with another value
to change the strategy use `message.timestamp.type` on the broker server
(0 or 1) .

