## Kafka with SpringBoot

kafka version used : kafka_2.13-3.9.0

prerequisite : kafka (kafka_2.13-3.9.0/other latest at your own rist T-T), what are publishers, subscribers & kafka topics, zookeeper (the much kafka knowledge you have the better it is ;-;), spring rest.

we got 2 applications, one is publisher and another one is subscriber (you can have n number of publishers and subscribers)

In the ApacheKafkaPub (com.cosa.config) we have bean which returns a KafkaTemplate (so the spring will have the bean ready for us which will be used in the service class)

This KafkaTemplate takes a producerFactory() as an input which creates a ProducerFactory for kafka producer config

This factory contains `BOOTSTRAP_SERVERS_CONFIG` which has Kafka broker URL, `KEY_SERIALIZER_CLASS_CONFIG` which serialize string to bytes (as kafka transmits data over the network in binary (bytes)), `VALUE_SERIALIZER_CLASS_CONFIG` this has a JacksonJsonSerializer class this will convert our java obj to json.

in the service class we add the data into the topic (topic name is in the ApplicationConstants.java class) and we return the string and have a look at the controller class.

Now, we create a subscriber have a look at ApacheKafkaSub's config class (rest the model and util are the same as the publisher application)
We have `ConsumerFactory` which is just like ProducerFactory but this will consume as soon as the producer produces one topic/data the new line here is the `GROUP_ID_CONFIG` one which simply assign one group id so the consumers with same group id consumes unique topic/data.

the other method which is `kafkaListener()` Creates a listener container factory which is used by @KafkaListener behind the scenes, sets consumerFactory()  so it knows how to consume messages.

`@KafkaListener()` : Tells Apache Kafka to listen to a topic.
topics : which topic to read from.
groupId : which consumer group it belongs to.
`subscriberMsgFromKafkaTopic()` : Method that runs whenever a message arrives.
String cxData : received message (already deserialized).

Producer -> Topic -> @KafkaListener -> this method prints message

Note: data is comming in json String not converted into Java Object.

What we do with this info how to run this: download kafka run zookeeper and the kafka server, after this run both pub and sub application and hit the endpoint check the logs of the ApacheKafkaSub application as soon as you hit the endpoint the json payload is visible on the console. :)
