# Hashes

Redis hashes are equivalent to JSON object. Use hashes to model domain objects

HASHES CANNOT BE NESTED !

# Commands
Most of the commands are O(1), HGETALL is O(n).

1. HSET <key> [... <field> <value>]
   1. create a new hash
   2. e.g. `HSET player:42 name Artexius race Elf level 4 hp 20 gold 20`
   3. if the <key> already exists, then the value are added or updated in the hash
2. HDEL  <key> <field>
   1. delete the field in a hash
3. HGET <key> <field>
   1. get the value of a field
4. HGETALL
   1. get all field and value in the hash
5. HMGET <key> [... <field>]
   1. get value of multiple fields
6. HINCRBY <key> <field> <x>
   1. increment the value of the <field> by <x> in the hash <key>
7. HINCRBYFLOAT <key> <field> <x>
   1. increment value o float field
8. HEXISTS <key> <field>
   1. check if field exists
9.  HSETNX <key> [... <field> <values>]
   1. set field value if does not exist

# use cases
1. rate limiting
2. session storage
