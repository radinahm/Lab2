package Char

abstract class Character(var attackPower:Int = 10, var Defense:Int = 7,
                var magicAttack:Int= 5, var magicDefense:Int = 7,
                var maxHealth:Int= 9, var maxMagic:Int = 7  ) {
  var currentHealth:Int = maxHealth
  var currentMagic:Int = maxMagic
  var alive:Boolean = true
  var experience:Int = 0
  var level:Int = 0
  var firepower:Int = 0
  var spell:Int = 0
  var newlst:List[String] = List()


  def takeDamage(damage:Int) : Int = {
    val newHealth: Int = currentHealth - damage

    if (newHealth <= 0){
      alive = false
    }
    else {
      alive = true
    }
    return newHealth

  }

  def physicalAttack(character1:Character): Int={
    val defpower:Int= character1.Defense
    val atkpower:Int= attackPower
    val dmg:Int = atkpower - defpower
    takeDamage(dmg)
  }
  def magicalAttack(character3:Character): Int={
    val mgcDefense:Int= character3.magicDefense
    val mgcAtk:Int= magicAttack
    val mgcdmg:Int = mgcAtk - mgcDefense
    takeDamage(mgcdmg)
  }
  def expgain(character: Character) : Int={
    val characterpower: Int = attackPower + Defense + magicAttack + magicDefense
    val characterpower2: Int = character.attackPower + character.Defense + character.magicAttack + character.magicDefense
    var newexp: Int = 0
    var newexp2: Int = 0
    if (characterpower > characterpower2){
      character.alive = false
      experience += 10
      newexp = 10
      currentHealth += 5
    }
    else {
      alive = false
      character.experience +=10
      newexp2 = 10
      character.currentHealth += 5
    }
    level += newexp/5
    character.level += newexp2/5
    character.level
  }
  def battleOptions(): List[String]
  def levelUp(): Unit
  def takeAction(string: String, character: Character): Unit


}
