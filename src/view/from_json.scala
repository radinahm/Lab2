package view
import javafx.event.EventHandler
import javafx.scene.input.{KeyCode, KeyEvent}
import scalafx.scene.shape.Circle
import play.api.libs.json.{JsValue, Json}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle}
import view.View.{model, sceneGraphics}



class from_json {
  var xtrans: Double = 0
  var ytrans: Double = 0
  val mod: to_json = new to_json
  val initialstr: String = mod.jsstr
  val parsed: JsValue = Json.parse(initialstr)
  var mapwidth2: Double = 0.0
  var mapheight2: Double = 0.0
  var tilearray: Array[Array[Map[String, JsValue]]] = Array()
  var truecount: Int = 0
  var falsecount: Int = 0
  val tileheight: Double = 250
  val tileWidth: Double = 250
  var otherpartyarray: Array[Map[String, JsValue]] = Array()
  var playerparty: Map[String, JsValue] = Map()
  var playerX: Double = 0.0
  var playerY: Double = 0.0

  def setup(str: String): Unit = {
    println(str)
    val parsed: JsValue = Json.parse(str)
    mapwidth2 = (parsed \ "mapSize" \ "width").as[Double]
    mapheight2 = (parsed \ "mapSize" \ "height").as[Double]
    tilearray = (parsed \ "tiles").as[Array[Array[Map[String, JsValue]]]]

    for (i <- tilearray) {
      for (j <- i) {
        var nj: String = j("passable").toString()
        var bool: Boolean = nj.toBoolean
        if (bool == true) {
          this.truecount += 1
          drawTile()

        }
        else {
          this.falsecount += 1
          drawTileyellow()
        }


      }
    }
    View.stage = new PrimaryStage {
      title = "2D Graphics"
      scene = new Scene(model.mapwidth2, model.mapheight2) {
        content = List(sceneGraphics)
        //
      }
    }

  }

  def drawTile(): Unit = {
    val newtile = new Rectangle {
      width = tileWidth
      height = tileheight
      fill = Color.Green
      translateX = x.getValue + xtrans
      from_json.this.xtrans += 250

    }
    View.sceneGraphics.children.add(newtile)


  }

  def drawTileyellow(): Unit = {
    val newtile = new Rectangle {
      width = tileWidth
      height = tileheight
      fill = Color.Yellow
      translateX = x.getValue + ytrans
      translateY = y.getValue + 250
      from_json.this.ytrans += 250

    }
    View.sceneGraphics.children.add(newtile)


  }

  def update(str2: String): Unit = {
    println(str2)
    val parsed: JsValue = Json.parse(str2)
    otherpartyarray = (parsed \ "otherParties").as[Array[Map[String, JsValue]]]
    playerparty = (parsed \ "playerParty").as[Map[String, JsValue]]
    playerX = (parsed \ "playerParty" \ "location" \ "x").as[Double]
    playerY = (parsed \ "playerParty" \ "location" \ "y").as[Double]
    var pllevel = (parsed\"playerParty"\"level").as[Int]
    println(playerX, playerY)
    val player: Circle = new Circle {
      centerX = playerX
      centerY = playerY
      radius = 5 * pllevel
      fill = Color.Blue

    }
    View.sceneGraphics.children.add(player)
    View.stage. addEventHandler(KeyEvent.KEY_PRESSED, new KeyEventHandler(player))
    for (i <- otherpartyarray) {
      var locationother = i("location")
      var xx1 = locationother("x").toString().toDouble
      var yy1 = locationother("y").toString().toDouble
      var lvl = i("level").toString().toInt
      var inbtl = i("inBattle").toString().toBoolean

      if (inbtl == true) {

        val player2: Circle = new Circle {
          centerX = xx1
          centerY = yy1
          radius = 5 * lvl
          fill = Color.Red

        }
        View.sceneGraphics.children.add(player2)
      }
      else {
        val player3: Circle = new Circle {
          centerX = xx1
          centerY = yy1
          radius = 5 * lvl
          fill = Color.Black

        }
        View.sceneGraphics.children.add(player3)

      }

    }
  }

}



