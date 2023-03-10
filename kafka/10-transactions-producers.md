# Transactional Producers
To add transactions to a kafka producers, set the transaction id configuration.
A transaction id should be unique to each producer, duplicated transactions
will conflict if they are used by more then one producer.
To start a transaction use the method `beginTransaction` to end the transaction
use either `abortTransaction` of `commitTransaction`. Do not start two
transactions at the same time in each producer, this will result in a error.
 
