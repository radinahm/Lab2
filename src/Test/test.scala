package Test

import Char.Character
import org.scalatest.FunSuite

class test extends FunSuite {

  test(testName  = "tests damage taken") {
    val newchar: Character = new Character(10, 7,
      5, 7,
      9, 7)
    val dmd: Int = 4
    val tr: Int = 9
    val nt: Int = 3
    newchar.takeDamage(damage = tr)
    assert(newchar.takeDamage(damage = dmd) == 5, dmd)
    assert((newchar.alive) == false)
    newchar.takeDamage(damage = nt)
    assert((newchar.alive) == false)



  }

}