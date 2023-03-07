# Work Distribution

Topic partitions are self contained, each partition has everything it needs to
operate. Each broker is responsible for one or more partitions.

## Who partitions are allocated?
Goals of partitions allocation:
1. Even distribution
2. Fault Tolerance  

These are goals, not rules because evenly distributing partitions can result in
a fault prone cluster. Partitions are distributed ordering brokers and then 
allocating partitions according to the list of brokers.
When ordering, kafka randomly select brokers alternating between brokers
running in different computers. To assign partitions, Kafka first allocates
leader partitions to each broker following the list order, then all followers
partitions in sequence starting from the second partition of the list. If the 
replication factor is greater than 2, the 3rd partitions will follow the same 
rule and start from the 3rd broker on the list. 


## Responsibility of the leader and follower

### Leader
The Leader broker is responsible for interacting with the producer and consumer.

### Follower
The follower copies data from the leader and stay up to date. The aim of the 
follower is to be elected as leader when the leader fails. The follower is 
synced with leader by continuously requesting data and persisting messages