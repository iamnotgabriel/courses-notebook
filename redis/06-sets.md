# Set

Unorded collection of single values, a value can not appear twice in a set.
Reads to a set is O(1).

sets contains only string

# Commands

1. SADD <key>  <value>
   1. add a value to a set
2. SCARD <key>
   1. number of element in a set
3. SISMEMBER <key> <value>
   1. checks if value is inside set
4. SINTER <key> [... <key2>]
   1. intersection between two or more sets
5. SMEMBERS <key> 
   1. list members in a set (not production) 
6. SSCAN <key> <cursor> [MATCH <pattern>]
   1. list members efficiently
7. SREM <key> [... <member>]
   1. remove member of a set
8. SPOP <key> <count>
   1. removes and return <count> elements from  a set.

## Operations with sets

1. union  : SUNION <key-set> [... <key-set> ]
2. intersection : SINTER (see above commands)
3. difference : SDIFF <key-set> [... <key-set>]

##  use cases
1. tag cloud 
2. unique visitors


# Sorted Set

Ordered (by score) collection of values.

# Commands
1. ZADD <key> <score> <member>
   1. add a pair to the ordered set
2. ZINCRBY <key> <increment> <member>
   1. add <increment> to the <score> of the <member>
3. ZRANGE <key> <start> <end>
   1. lowest to the highest
   2. WITHSCORES returns membes and scores
4. ZREVRANGE <key> <start> <end> [WITHSCORES]
   1. highest to the lowest  
   2. <start> and <stop> are indexes
5. ZREVRANK <key> <member>
   1. index member according to score rank in reverse order
6. ZSCORE <key> <member>
   1. score related to the <member> 
7. ZCOUNT: <min>  <max>
   1. count members between <min> and <max> 

## Operantions with sets

1. ZINTERSTORE <destination> <num-keys> [... <key>]
   1. intersect and store in key
2. ZUNIONSTORE <destination> <num-keys> [... <key>]
   1. union and  store in key
3. ZDIFF
   1. diff and store in key


## use case 
1. priority queue 
2. leader board 