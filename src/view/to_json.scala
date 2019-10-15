package view

import play.api.libs.json.{JsValue, Json}

class to_json {

  var numberOfTiles: Double = 4
  var TileWidth: Double = 250
  var TileHeight: Double = 250
  var mapWidth: Double = TileWidth * 2
  var mapHeight: Double = TileHeight * 2
  var str: String = ""
  var typeStr: JsValue = Json.toJson(str)
  var tile1: Map[String, JsValue] = Map(
    "type" -> typeStr,
    "passable" -> Json.toJson(true)
  )
  val t1json: JsValue = Json.toJson(tile1)
  var tile2: Map[String, JsValue] = Map(
    "type" -> typeStr,
    "passable" -> Json.toJson(false)
  )
  val t2json: JsValue = Json.toJson(tile2)
  var mapSize: Map[String, Double] = Map(
    "width" -> mapWidth,
    "height" -> mapHeight
  )
  val msJson: JsValue = Json.toJson(mapSize)
  var emptyarr1: Array[Map[String, JsValue]] = Array(tile1, tile1)
  var emptyarr2: Array[Map[String, JsValue]] = Array(tile2, tile2)
  val arr1json: JsValue = Json.toJson(emptyarr1)
  val arr2json: JsValue = Json.toJson(emptyarr2)
  var finalarray: Array[JsValue] = Array(arr1json, arr2json)
  val finalarrayjson: JsValue = Json.toJson(finalarray)
  var finalMap: Map[String, JsValue] = Map(
    "mapSize" -> msJson,
    "tiles" -> finalarrayjson
  )

  var jsstr: String = Json.stringify(Json.toJson(finalMap))

  def jsonparty(): Unit = {
    var x1: Double = 300.0
    var y1: Double = 100.0
    var x2: Double = 200.0
    var y2: Double = 200.0
    var x3: Double = 300.0
    var y3: Double = 300.0
    var xmainjs: JsValue = Json.toJson(View.xmainplayer)
    var ymainjs: JsValue = Json.toJson(View.ymainplayer)
    var xsxa: Double = 10 - View.xmainplayer
    var playerlocation: Map[String, Double] = Map(
      "x" -> View.xmainplayer,
      "y" -> View.ymainplayer
    )
    var jsplayerlocation: JsValue = Json.toJson(playerlocation)
    var playerlevel: Int = 5
    var jsplayerLevel: JsValue = Json.toJson(playerlevel)
    var playerMap: Map[String, JsValue] = Map(
      "location" -> jsplayerlocation,
      "level" -> jsplayerLevel,
      "inBattle" -> Json.toJson(false)
    )
    var jsplayerMap: JsValue = Json.toJson(playerMap)
    var otherpartylocation1: Map[String, JsValue] = Map(
      "x" -> Json.toJson(x1),
      "y" -> Json.toJson(y1)
    )
    var otherpartymap1: Map[String, JsValue] = Map(
      "location" -> Json.toJson(otherpartylocation1),
      "level" -> Json.toJson(5),
      "inBattle" -> Json.toJson(true)
    )
    var jsotherparty1: JsValue = Json.toJson(otherpartymap1)
    var otherpartylocation2: Map[String, JsValue] = Map(
      "x" -> Json.toJson(x2),
      "y" -> Json.toJson(y2)
    )
    var otherpartymap2: Map[String, JsValue] = Map(
      "location" -> Json.toJson(otherpartylocation2),
      "level" -> Json.toJson(4),
      "inBattle" -> Json.toJson(false)
    )
    var jsotherparty2: JsValue = Json.toJson(otherpartymap2)

    var otherpartylocation3: Map[String, JsValue] = Map(
      "x" -> Json.toJson(x3),
      "y" -> Json.toJson(y3)
    )
    var otherpartymap3: Map[String, JsValue] = Map(
      "location" -> Json.toJson(otherpartylocation3),
      "level" -> Json.toJson(8),
      "inBattle" -> Json.toJson(true)
    )
    var jsotherparty3: JsValue = Json.toJson(otherpartymap3)
    var otherpartyarr: Array[JsValue] = Array(jsotherparty1, jsotherparty2, jsotherparty3)
    var jsotherarr: JsValue = Json.toJson(otherpartyarr)
    var finalpartymap: Map[String, JsValue] = Map(
      "playerParty" -> jsplayerMap,
      "otherParties" -> jsotherarr
    )
    View.parties= Json.stringify(Json.toJson(finalpartymap))
  }
}
