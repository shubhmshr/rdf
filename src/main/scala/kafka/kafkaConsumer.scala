//package kafka
//
//import java.util.Properties
//
//object DemoConsumer {
//  def main(args:Array[String]): Unit ={
//
//    //Create properties instance
//    val props: Properties = new Properties()
//
//    //Setting properties
//
//    props.put("bootstrap.servers","broker1:9092")
//    props.put("group.id","firstTopic")
//    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
//    props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
//    props.put("enable.auto.commit","true")
//
//  }
//}