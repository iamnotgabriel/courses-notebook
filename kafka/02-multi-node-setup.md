# Multi node setup

To install a multi node setup you will need 1 instance of zookeeper. And any
quantity required of broker instances. To create a multi node on different
computers it is only necessary to change the broker.id in the
`/etc/kafka/server.properties` file.

To create a multi node instance on the same pc change log directory (logs.dir)
and the port of that the broker listens (listeners=PLAINTEXT://:9092).

When starting the broker server use another server.properties file to
adjust the configurations with the command
`kafka-server-start /etc/kafka/{server.properties.filename}`.
