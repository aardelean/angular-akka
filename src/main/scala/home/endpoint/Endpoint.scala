package home.endpoint

import java.util.Date

import akka.actor.{Props, ActorRef, Actor, ActorLogging}
import akka.util.Timeout
import home.config.PersistenceConfiguration._
import home.model.Person
import akka.pattern._
import spray.http.HttpMethods._
import scala.concurrent.Await
import scala.concurrent.duration._
import spray.http.{HttpRequest, HttpResponse, Uri}
import spray.routing.Directives._
import spray.routing.HttpServiceActor
import spray.json._


/**
 * Created by alex on 3/28/2015.
 * Simple actor
 */
class Endpoint() extends HttpServiceActor with ActorLogging{
  implicit val timeout : Timeout = 5 seconds
  val actor : ActorRef = context.actorOf(Props[ServiceActor])

  import home.model.Person._

  override def receive = runRoute{
    pathPrefix("spray"){
      path("persist") {
        get {
          parameter('p){ (p)=>
            complete("persisted")
          }
        }
      } ~ path("index") {
        get {
          parameter('key) {
            (key) => {
                complete(s"$key")
            }
          }
        }
      } ~ path("actor"){
        get{
            complete{
              Await.result(( actor ? "ACTOR RESPONSE"), timeout.duration).asInstanceOf[String]
            }
        }
      } ~ path("friends"){
        get{
          complete(List(Person("Alex", 30, "male"), Person("Andreea", 30, "female")).toJson.prettyPrint)
        }
      }
    }
  }
}
