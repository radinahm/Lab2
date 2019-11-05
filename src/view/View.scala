package view
import javafx.scene.input.{KeyEvent, MouseEvent}
import play.api.libs.json.{JsValue, Json}
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.control.TextField
import scalafx.scene.effect.BlendMode.Green
import scalafx.scene.layout.VBox
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle, Shape}
import scalafx.scene.{Group, Scene}
object View extends JFXApp {


  var xmainplayer: Double = 100.90
  var ymainplayer: Double = 107.86
  val model: from_json = new from_json
  val model2: to_json = new to_json
  val sceneGraphics: Group = new Group{}
  var mapwd: Double = 0
  var maph:Double = 0
  var parties: String = ""
  model.setup(model2.jsstr)
  def update(time: Long): Unit ={
    model2.jsonparty()
    model.update(parties)
  }
  AnimationTimer(update).start()

  def iscollison(): Unit={

  }
}

