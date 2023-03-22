# Lists

"Ordered sequence of strings" - bearded but of the course
like : arraylist (java), array (js), list (python)
list can have more than 4G elements 
lists can contains only strings 
list is implement using doubly linked list

# Commands

1. RPUSH  <key> <value>
   1. push a new value in the end of the list
   2. O(1)
2. LPOP <key>
   1. removes and return the first element on the list
   2. O(1)
3. RPOP
   1. removes and return the last element on the list
   2. O(N)
4. LRANGE <key> <start> <end>
   1. return elements from  <start> to <end> inclusive
   2. negative numbers can be used to refer to end of the list 
   3. 0(s+n) [s = distance from <start> to the beginning of the list]
5. LLEN
   1. length of list
   2. O(1)
6. LINDEX <key> <index>
   1. get value in a index
7. LINSERT <key> <BEFORE|AFTER> <value>
   1. insert a value relative to another value
8. LSET <key> <index> <value>
   1. insert <value> at <index>
9.  LREM <key> <count> <value>
    1.  remove elements with a certain value
    2.  <count> = 0 remove all 
    3.  <count> > 0 remove from head to tail
    4.  <count> < 0 remove from tail to head 


# use case
 * most recent activity
 * inter process communication (produce and consume event in the correct order)