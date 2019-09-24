package Test

import Char.Character
import org.scalatest.FunSuite
import Char.Party

class test extends FunSuite {

  test(testName  = "tests damage taken") {
    val newchar: Character = new Character(10, 7,
      5, 7,
      9, 7)
    val dmd: Int = 4
    val tr: Int = 9
    val nt: Int = 3
    val newchar1: Character = new Character(10, 7,
      5, 7,
      9, 7)
    val newchar2: Character = new Character(10, 7,
      5, 7,
      9, 7)
    newchar.takeDamage(tr)
    newchar1.takeDamage(nt)

    assert((newchar.alive) == false, tr)
    assert((newchar1.alive) == true, nt)
    assert(newchar2.takeDamage(dmd)==5)
  }

  test(testName = "tests attack"){
    val newcplayer: Character = new Character(10, 7,
      10, 7,
      9, 7)
    val newcplayer2: Character = new Character(10, 4,
      5, 7,
      9, 7)
    assert((newcplayer.physicalAttack(newcplayer2)) == 3)
    assert((newcplayer.magicalAttack(newcplayer2)) == 6)
  }

  test(testName = "experiencegainvariable"){
    val newguy: Character = new Character(10, 7,
      10, 7,
      9, 7)
    val newguy1: Character = new Character(10, 4,
      5, 7,
      9, 7)
    assert(newguy.currentHealth == 9)
    newguy.expgain(newguy1) // newguy wins and gains 10 exp
    assert(newguy1.experience==0)
    assert(newguy.experience==10)
    assert(newguy.currentHealth == 14)
    assert(newguy.level==2)
    val newguy2: Character = new Character(9, 4,
      5, 7,
      9, 7)
    newguy2.expgain(newguy)
    assert(newguy.experience==20)
    assert(newguy.level ==4)
    assert(newguy.currentHealth == 19)
  }
test(testName = "Partytest"){
  val newa: Character = new Character(13, 7,
    10, 7,
    9, 7) // newa defeats new b, d, and f

  val newb: Character = new Character(10, 4,
    5, 7,
    9, 7)
  val newc: Character = new Character(10, 7,
    10, 7,
    9, 7) // newc defeats new b, new f
  val newd: Character = new Character(12, 7,
    10, 7,
    9, 7)
  val newe: Character = new Character(12, 7,
    10, 7,
    9, 7) // new e defeats new b, new f
  val newf: Character = new Character(8, 7,
    10, 7,
    9, 7)
  val newp: Party = new Party(List(newa, newc, newe))
  val newp1: Party = new Party(List(newb, newd, newf))
  newp.partySetup(newp1)
  assert(newp.xpgain==20)
  assert(newa.experience == 50)
  assert(newc.experience == 20)
  assert(newd.experience == 20)
}




}