# Storage Architecture

## What kafka really is ?
Apache Kafka is a **horizontally scalable**, **fault tolerant**, **distributed**
streaming platform.

## Section content
1. Kafka Storage Architecture
2. Kafka Cluster Architecture 
3. Work Distribution Architecture

## Kafka Storage Architecture
Topics are persisted in log files at least one for each topic.  Logs are also
partitioned  and replicated.

## Topics and storage

### What is a topic?
Logical name to group messages

### What is a topic partition?
A physical directory on the the kafka node.

### What is replication factor
Number of copies of each partition
Example:
Partitions = 3
Replication = 2 
Number of replicas(6) = Partitions(3) * Replication Factor(2)

Replicas are stored in different brokers

## Partitions
A partition can be a leader or a follower 
The leader is the original partition, the followers are replicas created in other
brokers

### how to know if a partition is a leader or followers
```
$ kafka-topics --describe --zookeeper {zookeeper-address} --topic {topic-name}
```

## Log files

### Log Segments
Replica -> Log Segments
Logs are stored in the replica folder in multiple files
When the maximum size of a log segment is reached kafka creates a new log segment.

the default maximum size is a 1GB or a week of data, and each segment receives
has the number offset of the first message. 

### Message Offsets
each kafka message  is uniquely identified within a single partition by a 64bit integer.
To identify a message, you need the topic name, partition number and de offset number.

### Message Index 
Kafka maintains a index offsets to quickly access messages.

### Kafka Timeindex
Messages are also index by timestamp with the consumer wants to read messages based on time.

