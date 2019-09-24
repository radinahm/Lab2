package Char
import Char.Character

class Party(var list: List[Character]) {
  var xpgain: Int = 0
  def partySetup(defeatedParty: Party): Int ={
    var defeatedexp: Int = 0
    for (value <- defeatedParty.list){

      for (i <- list){
        i.expgain(value)
        defeatedexp += value.experience
      }
      defeatedexp
    }
    defeatedexp
    var membercount:Int = 0
    for (r <- list){
      membercount += 1
    }
    membercount
    var eachxpgain: Int = defeatedexp/membercount
    xpgain = eachxpgain
    eachxpgain
    //done

  }

}
