# Cluster Architecture

## What is Kafka Cluster?
A Kafka Cluster is a group of brokers who work together to share a workload.
That is how Kafka becomes distributed and scalable system.

## Cluster Membership
In distributed systems, there is a master node that maintain the list of all
active members and the state of members, and manages the addition of members
to the cluster.

## Administrative Tasks
In the case of a member leave the cluster a coordinator will reassign the tasks
of that member to another.

## Who manages cluster membership ?
Apache Kafka is a Masterless Cluster, but it uses Zookeeper to manage the list 
active brokers.
Every kafka broker has unique id defined in the config file, zookeeper tracks
the brokers in the cluster with the list of ephemeral node ids in the
`/brokers/ids` file.

# Kafka Controller
A broker that is responsible for reassigning tasks after a brokers leaves the
cluster. The controller is not a Master node, it is usual node elected to have
for responsibility.
The controller is the first node that started in the cluster.



