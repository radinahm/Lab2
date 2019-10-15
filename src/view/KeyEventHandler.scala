package view
import javafx.event.EventHandler
import javafx.scene.input.{KeyCode, KeyEvent}
import scalafx.scene.shape.Circle
class KeyEventHandler(player: Circle) extends EventHandler[KeyEvent]{
  val model: to_json = new to_json
  val model2: from_json = new from_json
  val playerSpeed: Int = 10

  override def handle(event: KeyEvent): Unit = {
    keyPressed(event.getCode)

  }
  def keyPressed(keycode: KeyCode): Unit ={

    keycode.getName match {
      case "W" => player.translateY.value -= playerSpeed
        View.ymainplayer += playerSpeed


      case "A" => player.translateX.value -= playerSpeed
        View.xmainplayer -= playerSpeed

      case "S" => player.translateY.value += playerSpeed
        View.ymainplayer += playerSpeed
      case "D" => player.translateX.value += playerSpeed
        View.xmainplayer += playerSpeed

      case _ => println(keycode.getName + " pressed with no action")
    }
  }


}
