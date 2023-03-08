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
3. MessageKey: key of the value pair of the message (consider it mandatory)
4. Timestamp: when the message was sent

### ProducerSerializer
Convert the value of the key and value to array of bytes.
Every message follows this path before it is send to the broker:
1. Serialization
2. Partitioning
3. Stored in a buffer
