package kafka

import org.apache.kafka.clients.producer.ProducerRecord

object DemoProducer extends ProducerProperty {
  def main(args: Array[String]) = {

    for (a <- 1 to 4) {
      val record: ProducerRecord[String, String] = new ProducerRecord("firstlove", "key", s"Hello $a")
      producer.send(record)
    }
    producer.close()
  }
}
