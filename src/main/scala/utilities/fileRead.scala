package utilities
import java.io._
import GUI._
import diagrams._
import diagramVisualizer._

object fileRead {

  // Filetype is one of three, "line", "histo" or "pie"

  def readFile(sourceFile: File, filetype: String): Unit = {

    val readMyFile = try {
      new FileReader(sourceFile)
    } catch {
      case e: FileNotFoundException => println("File not found!")
        return
    }

    val lineReader = new BufferedReader(readMyFile)

    try {
      var inputLine = lineReader.readLine()

      if(inputLine != null){
        filetype match {

          // Creates a line diagram
          case "line" => {
            var newDiagram = new lineDiagram

            while(inputLine != null){
              if(inputLine.head == '#') {
                // ignores comments
              }
              else{
                // adds data to newDiagram
                val x = inputLine.split(',').apply(0).toInt
                val y = inputLine.split(',').apply(1).toInt
                newDiagram.addData(x, y)
              }
              inputLine = lineReader.readLine()
            }

            // Adding to array will be useful for adding color buttons for each of the line diagrams.
            lineDiagramsInArray = lineDiagramsInArray :+ newDiagram
            println(lineDiagramsInArray.length)
            drawLineDiagram(newDiagram)
          }

          // creates a new histogram
          // works in a similar manner to the above lineDiagram case
          case "histo" => {
            var newDiagram = new histogram

            while(inputLine != null){
              if(inputLine.head == '#'){
                // Ignores comments, which are the lines starting with a #-symbol
              }
              else{
                val x = inputLine.split(',').apply(0).toInt
                val y = inputLine.split(',').apply(1)
                newDiagram.addData(x, y)
              }
              inputLine = lineReader.readLine()
            }

            diagramVisualizer.currentHistogram = Option(newDiagram)
            diagramVisualizer.drawHistogram(newDiagram)
          }

          // creates a pie diagram
          case "pie" => {

          }


          case _ => {

          }
        }
      }




    }
  }
}
