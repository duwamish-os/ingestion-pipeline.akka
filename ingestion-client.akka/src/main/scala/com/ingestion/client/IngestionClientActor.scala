package com.ingestion.client

import java.io.File

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

class IngestionClientActor extends Actor {

  override def preStart(): Unit = {

    val remoteActor = context.actorSelection("akka.tcp://IngestionSystem@127.0.0.1:5150/user/ingestion")
    println("[INFO] Ingestion endpoint : " + remoteActor)

    remoteActor ! """{"TestEvent" : {"data": "some data"}}"""

  }

  override def receive: Receive = {

    case notification:String =>
      println("[INFO] got event notification from ingestion endpoint " + notification)

  }

}

object IngestionClientActor {

  def main(args: Array[String]) {

    val configFile = getClass.getClassLoader.getResource("application.conf").getFile
    val config = ConfigFactory.parseFile(new File(configFile))
    val system = ActorSystem("ClientSystem",config)

    val localActor = system.actorOf(Props[IngestionClientActor], name="ingestionclient")
  }

}