package Char

class witch extends Character() {
  magicAttack = 10
  var str: String = "spell"


  override def battleOptions(): List[String] = {
    if (this.spell >= 2) {
      newlst = List("spell")
    }
    else {
      newlst = List()
    }
    newlst


  }


  override def levelUp(): Unit = {
    level += 2
    spell += 4
    magicDefense += 3
  }
  override def takeAction(string: String, character: Character): Unit ={
    character.currentHealth = character.currentHealth - 4

  }

}
