package home.endpoint


import akka.actor.Actor
import home.config.PersistenceConfiguration._
import home.model.Person


/**
 * Created by alex on 4/22/2015.
 */
case class FetchAllPersons()
case class HardCoded()

case class PersistRandomPerson(name:String)

class PersistPersonActor extends Actor{


  override def receive(): Receive ={
    case newObject: PersistRandomPerson => {
      var inserted :Option[Person] = None
       transactional{
        inserted = Some(new Person(newObject.name, 41, "male"))
       }
       sender ! inserted.get;
    }case FetchAllPersons => {
      transactional{
        sender! all[Person]
      }
    }case HardCoded => sender ! List(Person("Alex", 30, "male"), Person("Andreea", 30, "female"))

  }
}
