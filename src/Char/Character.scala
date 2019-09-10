package Char

class Character(val attackPower:Int = 10, val Defense:Int = 7,
                val magicAttack:Int= 5, val magicDefense:Int = 7,
                val maxHealth:Int= 9, val maxMagic:Int = 7  ) {
  var currentHealth:Int = maxHealth
  var currentMagic:Int = maxMagic
  var alive:Boolean = true
  def takeDamage(damage:Int) : Int = {
    val newHealth: Int = currentHealth - damage
    if (newHealth <= 0){
      alive = false
    }
    return newHealth

  }
}
