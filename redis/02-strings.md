# strings

"binary safe sequence of bytes" - bearded guy of the course redis stings can be
used to cache:
1. API responses
2. Session storage
3. HTML pages
4. Counters

Any string is limited to 512MB, if a string is UTF-8 then the maximum length is
512

# Commands
1. SET <key> <value> EX  <seconds>
   1. set a value with an expiration date in seconds
2. TTL <key>
   1. return the number of seconds a key will expire
3. INCR <key> 
   1. increment string by one
   2. if does not exist create one and then add 1
   3. *RELATED TO DECR
4. INCRBY <key> <x>
   1. adds <x> to the value of <key>
   2. if does not exist create one and then add <x>
   3. *RELATED TO DECRBY
5. INCRFLOAT
   1. used to increment floats
6. DEL <key>
   1. delete a value synchronously 
7. UNLINK <key>
   1. unlink value of key and deletes value async 
8. EXPIRE <key> <seconds>
   1. set the expiration in <seconds> of a value by <key>

# how redis can increment a string ?
A string can be encoded as integer. to look that use `object encoding <key>`