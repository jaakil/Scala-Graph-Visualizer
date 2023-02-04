package GUI
import diagrams._
import GUIApp._
import scalafx.scene.paint.Color._
import buttons._
import grid.zoomState

object diagramVisualizer {

  // is either line, histo or pie
  // initially line, but the diagram is empty
  var diagramType = "line"

  val dvc = diagramCanvas.graphicsContext2D
  dvc.setTransform(1,0,0,-1,0,diagramCanvas.getHeight)

  // Default color is blue
  dvc.setStroke(Blue)


  // Saves the currently written line diagrams
  var lineDiagramsInArray: Array[lineDiagram] = Array()

  // Saves the current histogram
  var currentHistogram: Option[histogram] = None

  // Draws a line diagram
  def drawLineDiagram(lineDiagram: lineDiagram): Unit = {

    // Changes the settings to the correct ones
    if(diagramType != "line"){
      clearDiagram()
      grid.removeGrid()
      diagramType = "line"
    }

    val diagramData = lineDiagram.dataArray
    dvc.setStroke(lineDiagram.color)
    createButtonsForLine(lineDiagram)

    for(i <-0 until  diagramData.length-1) {
      dvc.strokeLine(diagramData(i)._1*zoomState,diagramData(i)._2*zoomState, diagramData(i+1)._1*zoomState,diagramData(i+1)._2*zoomState)
    }

  }

  // Draws a histogram
  def drawHistogram(histo: histogram): Unit = {
    // Clears the previous diagram, as one can only have on histogram simultaneously
    clearDiagram()
    buttonBox.children.clear()

    // Changes diagram type
    diagramType = "histo"

    // Clears the array for lineDiagrams
    lineDiagramsInArray = Array()

    // Set color as blue. Makes histograms clearer when everything is the same color, and blue is commonly used.
    dvc.setStroke(Blue)



  }

  // Draws a pie diagram
  def drawPieDiagram(pie: pieDiagram) = {
    // only one diagram may exist at once
    clearDiagram()
    grid.removeGrid()
    diagramType = "pie"
  }



  // Clears the diagram
  def clearDiagram(): Unit = {
    dvc.clearRect(0, 0, diagramCanvas.getWidth, diagramCanvas.getHeight)
  }


  // Updates the line diagrams, for example after changing the colors.
  def updateLines(): Unit = {

    buttonBox.children.clear

    // Clears out the previous diagrams
    clearDiagram()
    redrawLineDiagrams()


  }


  def redrawLineDiagrams(): Unit = {
    lineDiagramsInArray.foreach(a => drawLineDiagram(a))
  }

  def emptyBottomBox(): Unit = {
    bottomBox.children.clear()
  }



}
