# In Sync Replica list

List of follower partitions that are in sync with the leader. If the leader
partition fails, then a new leader must be elected. The ISR list dictates who
can be elected as a new leader based on the sync of the follower with
the leader.
The ISR is a dynamic list, and changes with time. If the follower has requested
the newest data within 10 seconds then it enters the ISR list, if not the 
follower is expelled from the ISR list. (the 10 seconds time can be adjusted in
the configuration file).
