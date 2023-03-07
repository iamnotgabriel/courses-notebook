# In Sync Replica list

List of follower partitions that are in sync with the leader stored zookeeper.
If the leader partition fails, then a new leader must be elected. The ISR list
dictates whocan be elected as a new leader based on the sync of the follower 
with the leader.
The ISR is a dynamic list, and changes with time. If the follower has requested
the newest data within 10 seconds then it enters the ISR list, if not the 
follower is expelled from the ISR list. (the 10 seconds time can be adjusted in
the configuration file).

## Handling edge cases

What if all the followers are out of sync and the leader fails ?

### Committed vs Un-committed changes

When a message is written in all replicas, it is considered a committed
message. These messages are safe and the failing of the leader does not impact
them. The producer can choose to receive acknowledgment of the request when all
messages committed, so if the leader fails the producer can try again (as a new
leader will be elected).

### Minimum in sync replicas

When all the followers nodes are down a change is considered committed when
only the leader writes the data. This can lead to data loss if the leader 
fails. So adjust this, set the `min.insync.replicas` configuration to prevent
this behavior. Note that if there is less insync replicas than the minimum, the
it not possible write on that partition and kafka will return Not Enough 
Replicas error to the producer, this partition will be read only until the
minimum of replicas are in sync.
