package Char

class tank() extends Character() {
  attackPower = 7
  currentHealth = 18
  var str:String = "firepower"


  override def battleOptions(): List[String] ={
    if (this.firepower >=2){
      newlst = List("firepower")
    }
    else {
      newlst = List()
    }
    newlst


  }


  override def levelUp(): Unit ={
    level += 2
    firepower += 4
    Defense += 3
  }

  override def takeAction(string: String, character: Character): Unit ={
   character.currentHealth = character.currentHealth - 4

  }









}
