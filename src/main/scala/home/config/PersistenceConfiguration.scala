package home.config

import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.storage.relational.PooledJdbcRelationalStorage
import net.fwbrasil.activate.storage.relational.idiom.mySqlDialect

/**
 * Created by alex on 4/13/2015.
 */
object PersistenceConfiguration extends ActivateContext {
  val storage = new PooledJdbcRelationalStorage {
    val jdbcDriver = "com.mysql.jdbc.Driver"
    val user = new Some("root")
    val password = new Some("root")
    val url = "jdbc:mysql://localhost:3306/users"
    val dialect = mySqlDialect
  }
  override protected def entitiesPackages = List("home.model")

}
