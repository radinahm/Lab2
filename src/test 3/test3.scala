package test3

import Char.Character
import org.scalatest.FunSuite
import Char.Party
import Char.tank
import Char.witch

class test3 extends FunSuite {
  test(testName = "tests for battle options for tank") {
    val tank1: tank = new tank
    assert(tank1.battleOptions()== List())
    tank1.levelUp()
    assert(tank1.level == 2)
    assert(tank1.battleOptions()== List("firepower"))
  }
  test(testName = "tests for battle options for witch") {
    val witch1: witch = new witch
    assert(witch1.battleOptions()== List())
    witch1.levelUp()

    assert(witch1.level == 2)
    assert(witch1.battleOptions()== List("spell"))
  }
  test(testName = "tests stats for tank"){
    val tank1: tank = new tank
    assert(tank1.Defense == 7)
    tank1.levelUp()
    assert(tank1.Defense == 10)
  }
  test(testName = "tests stats for witch"){
    val witch1: witch = new witch
    assert(witch1.magicDefense == 7)
    witch1.levelUp()
    assert(witch1.magicDefense==10)
  }
  test(testName = "tests takeaction tank"){
    val tank1: tank = new tank
    val witch1: witch = new witch
    assert(witch1.currentHealth == 9)
    tank1.takeAction("firepower", witch1)
    assert(witch1.currentHealth== 5)
  }
  test(testName = "tests takeaction witch"){
    val tank1: tank = new tank
    val witch1: witch = new witch
    assert(tank1.currentHealth ==18)
    witch1.takeAction("spell", tank1)
    assert(tank1.currentHealth == 14)

  }



}
