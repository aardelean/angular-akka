package home.model

/**
 * Created by alex on 4/11/2015.
 */

import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.entity.Entity
import net.fwbrasil.activate.storage.relational.PooledJdbcRelationalStorage
import net.fwbrasil.activate.storage.relational.idiom.mySqlDialect
import spray.json._


case class Person(var name: String, var age:Integer, var gender: String) extends Entity{
}

object Person extends DefaultJsonProtocol{
  implicit object PersonJsonFormat extends RootJsonFormat[Person] {
    def write(c: Person) = JsObject(
          ("id", JsString(c.id)),
          ("name", JsString(c.name)),
          ("age", JsNumber(c.age)),
          ("gender", JsString(c.gender))
        )

    def read(value: JsValue) = value match {
      case JsArray(Vector(JsString(name), JsNumber(age), JsString(gender))) =>
        new Person(name, age.toInt, gender)
      case _ => deserializationError("Person expected")
    }
  }
}
