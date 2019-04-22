package kafka

import java.util.Properties

import org.apache.kafka.clients.producer.KafkaProducer

trait ProducerProperty {

  val producerProps: Properties = new Properties()
  producerProps.put("bootstrap.servers", "localhost:9092")
  producerProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  producerProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  val producer: KafkaProducer[String, String] = new KafkaProducer[String, String](producerProps)

}

//
////trait ConsumerProperty{
////  val consumerProps: Properties = new Properties()
////
////  //Setting properties
////  consumerProps.put("bootstrap.servers","127.0.0.1:9092")
////  consumerProps.put("group.id","firstTopic")
////  consumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
////  consumerProps.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
////  consumerProps.put("enable.auto.commit","true")
////}