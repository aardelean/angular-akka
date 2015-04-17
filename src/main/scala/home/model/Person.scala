package home.model

/**
 * Created by alex on 4/11/2015.
 */

import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.entity.Entity
import net.fwbrasil.activate.storage.relational.PooledJdbcRelationalStorage
import net.fwbrasil.activate.storage.relational.idiom.mySqlDialect



class Person(var name: String) extends Entity{


}
