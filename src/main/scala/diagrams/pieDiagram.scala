package diagrams
import scalafx.scene.paint.Color
import scalafx.scene.paint.Color._

class pieDiagram {

  // Simple pie diagram class, where the array stores the data
  // Int is the numerical value, String is the name associated with said value

  var dataArray: Array[(Int, String, Color)] = Array()

  def addData(value: Int, name: String, color: Color): Unit = {
    dataArray = dataArray :+ (value, name, color)

  }

  def sortArray(): Unit = {
    dataArray = dataArray.sortWith(_._1 < _._1)
  }

}
