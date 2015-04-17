package home.endpoint

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
 * Created by alex on 4/15/2015.
 */
class ServiceActor extends Actor{
  override def receive: Receive = {
    case message@_ => sender ! "TEST"
  }
}
