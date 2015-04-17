package home

import org.scalatest.FunSpec
import scala.concurrent.duration._

import scala.concurrent.{Promise, ExecutionContext, Await, Future}

/**
 * Created by aardelean on 16.04.2015.
 */
class ComprehensionsTest extends FunSpec {
  implicit val xc: ExecutionContext = ExecutionContext.global
  describe("Testing 2 futures"){
    val future1 = Future{"asd "+"dfdf"}
    val future2 = future1.map{
      s => s.length
    }
    val result = Await.result(future2, 1 second)
    it("second future computation should be 8"){
      assert(8==result)
    }
  }
  describe("Promise example"){
    val f1 = Future {
      "Hello" + "World"
    }
    val f2 = Promise.successful(3)
    val f3 = f1 flatMap { x ⇒
      f2.future map { y ⇒
        x.length * y
      }
    }
    val result = Await.result(f3, 1 second)
    it("promise future combination"){
      assert(30==result)
    }
  }
  describe("second promise play"){
    val f = Future { 1 }
    val p = Promise[Int]
    p completeWith f
    p.future onSuccess {
      case x => println(x+"dasda")
    }
  }
}
