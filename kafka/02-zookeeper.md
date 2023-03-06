# What is zookeeper

A kind of DB used to share information between Kafka nodes. Necessary to run
even with single node. (It will be discontinued)

# Creating a topic

## Partitions

consider:

1. Storage requirements
2. Parallel Processing Requirement

## Replication Factor

Number of copies of each partition (high workflows require 2 or 3)

## Bootstrap server

The address of the broker service

```
$ kafka-topic --create --topic test --partitions 1 --replication-factor 1 --bootstrap-server localhost:9092
```
