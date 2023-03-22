# Faced Search
Solve searching problems with multiple data structures.

1. Object Inspection
2. Faced Search
   1. Navigation
   2. Search across multiple criteria
   3. Filter across multiple criteria
3. Hashed index

# Traditional solutions  
Secondary Indexes
Full text search


# Object Inspection
Store object in a set as a string, return objects and filter the matches
in the application.
Not ideal for production, the cost increases for each object stored and
each key that is searched

# Faced search
Store ids of the objects in sets by key and value, e.g. `fs:price-range:budget`,
`fs:price-range:premium`, `fs:category:cars`, `fs:category:kitchen`. To search
for the wanted value, execute the intersections of the sets to search for the
value like this: `SINTER fs:price-range:budget fs:category:cars`, after this,
fetch each object with `GET item:{id-returned-by-sinter}`.

## Performance
The cost of `sinter` will be proportional to size of the smallest set and the
number of sets in the query. So the distribution of the values and the quantity
of the parameters in the search will affect the performance.

# Hashed search
To avoid the performance penalties of `sinter`, sets can be constructed 
differently. Instead to segregating values by single key and value, build sets
based on multiple values and hash to get a string.
For example the set of budget cars will be `hfs:7d197f1967464ba684b4d998debde`,
and the set of cars `hfs:16514e3431331f5a59cd16f10f633711` ... sets can be 
created for multiple key values pair specific to most used filters.

## Performance
With this approach, the performance of the search will linear and proportional
to the values in the target set. The down side of this approach is that changes
of the objects values will result in the removal of the object id the set and 
the insertion in another set, so avoid this approach if objects change a lot.
