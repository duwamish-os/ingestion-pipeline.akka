package ingestion.endpoint

import java.io.File
import java.util.Date

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

class IngestionActor extends Actor {

  override def receive: Receive = {

    case event: String => {
      println("[INFO] received " + event + " from " + sender)
      sender ! s"""{ "EventProcessed": { "date" : ${new Date()} } }"""
    }
    case _ => println("[INFO] Received unknown event ")
  }

}

object IngestionActor {

  def main(args: Array[String]) {
    val configFile = getClass.getClassLoader.getResource("application.conf").getFile
    val config = ConfigFactory.parseFile(new File(configFile))

    val system = ActorSystem("IngestionSystem", config)
    val remote = system.actorOf(Props[IngestionActor], name = "ingestion")

    println("[INFO] endpoint actor is ready")
  }

}
