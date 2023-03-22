# Keys

Keys in redis are byte sequences (case sensitive strings). Keys may have up to
512MB. 

# Naming keys
The usual convention of naming keys are using placeholders, values and separate
with `:`. 
1. user:1000
2. posts:300:comments
3. 

# Commands

1. SET : use `SET` to create a new value pair
   1. SET <key> <value> [NX|XX]
      1. NX : set if values does no exist
      2. XX : set only if value already exists
2. GET : get values of keys
3. EXISTS  : check if key exists
4. KEYS : list keys of a given pattern  (blocking)
   1. KEYS <pattern>
   2. keys is not safe of production because it is blocking
5. SCAN : list keys with a pattern (non blocking)
   1. SCAN <cursor> <pattern> COUNT <int>
      1. cursor : current `page` of keys
      2. pattern : string to search like `user:*`
      3. count : specify number of itens in each page