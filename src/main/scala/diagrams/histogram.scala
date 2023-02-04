package diagrams

class histogram {
  // A simple histogram class meant for saving and adding data
  // Has an Int for storing the numberical values and String for storing names

  var dataArray: Array[(Int, String)] = Array()


  // pretty self-explanatory
  def addData(value: Int, name: String): Unit = {
    dataArray = dataArray :+ (value, name)
    // Doesn't need to be sorted here, really.
  }

  // Sorts the data. Used only when user wants the data to be sorted.
  // Is sorted by the value
  def sortAscending(): Unit = {
    dataArray = dataArray.sortWith(_._1 < _._1)
  }

  // The same, but descending
  def sortDescending(): Unit = {
    dataArray = dataArray.sortWith(_._1 > _._1)
  }
}
