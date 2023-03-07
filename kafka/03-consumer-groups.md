# Consumer groups

To follow these steps, create a kafka cluster (example in the `multi-node-docker-compose.yml`).

## Create a kafka topic

```
$ kafka-topics --create --topic stock-ticks --bootstrap-server broker-1:9092 --partitions 3 --replication-factor 1
```

```
$ kafka-console-consumer --bootstrap-server broker-1:9092 --topic stock-ticks --group  stock-ticks-group
```
