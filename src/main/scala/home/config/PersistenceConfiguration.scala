package home.config

import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.storage.mongo.MongoStorage

/**
 * Created by alex on 4/13/2015.
 */
object PersistenceConfiguration extends ActivateContext {
  val storage = new MongoStorage  {
    val host = "ds035240.mongolab.com"
    override val port = 35240
    val db = "scala"
    override val authentication = Option("admin", "admin")
  }
  override protected def entitiesPackages = List("home.model")

}
