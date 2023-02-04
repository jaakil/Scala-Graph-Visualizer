package diagrams

import scalafx.scene.paint.Color._

class lineDiagram{
  // An array, where data is saved in the format (X, Y)
  var dataArray: Array[(Int, Int)] = Array()

  // Name is initially empty, and the color is black
  var name = ""
  var color = Black

  // Adding data is done using this method.
  def addData(x: Int, y: Int):Unit = {
    dataArray = dataArray :+ (x,y)
    // Keeping the array sorted by x is important, so that the arrays are neatly organized.
    dataArray = dataArray.sortWith(_._1 < _._1)
  }
  def setName(newName: String) = {
    name = newName
  }
}

