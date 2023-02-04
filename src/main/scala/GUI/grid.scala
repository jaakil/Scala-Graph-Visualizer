package GUI
import GUIApp._
import scalafx.scene.paint.Color._

object grid {

  // if state is false, no grid
  // if true, grid
  var state = false

  // Defines how big the squares formed by the grid will be
  // Default is 40
  // Possible options for grid size are 40, 80 and 160
  val defaultSquareSize = 40
  var squareSize = defaultSquareSize

  // Zoom state, meant to measure how zoomed in the values of the grid are.
  // Essentially works as a multiplier, 1 is the default.
  // If zoom state were to be increased to 2, the diagrams go up in size.
  var zoomState = 1

  val gc = canvas.graphicsContext2D
  gc.setGlobalAlpha(0.2)
  gc.setStroke(Black)

  //draws grid, marks state as true
  def drawGrid(): Unit = {
    state = true

    for(i <- 0 to canvas.getWidth.toInt/(squareSize)){

      gc.setLineDashes(5)
      // Vertical lines
      gc.strokeLine(i*squareSize,0,i*squareSize,canvas.getHeight)
      // Adds x-axis numbers
      gc.setGlobalAlpha(1)
      gc.fillText((i*squareSize/zoomState).toString, (i*squareSize)+5 , canvas.getHeight-5)
      gc.setGlobalAlpha(0.2)

      // Horizontal lines
      gc.strokeLine(0,i*squareSize, canvas.getWidth, i*squareSize)
      // Adds y-axis numbers
      gc.setGlobalAlpha(1)
      gc.fillText((i*squareSize/zoomState).toString, 5, canvas.getHeight-(i*squareSize)-5)
      gc.setGlobalAlpha(0.2)
    }
  }

  def removeGrid(): Unit = {
    state = false
    //clears the drawn lines
    gc.clearRect(0, 0, canvas.getWidth, canvas.getHeight)
  }

  def toggleGrid(): Unit = {
    if(this.state){
      removeGrid()
    }
    else drawGrid()
  }


  // Reduce the square size of the grid
  def decreaseSquareSize(): Unit = {

    // Cannot go below 40, as it makes understanding the graph more difficult.
    squareSize = Math.max(squareSize/2, 40)
    removeGrid()
    drawGrid()
  }

  def increaseSquareSize(): Unit = {

    // Cannot go above 160, not much use to have it beyond that point.
    squareSize = Math.min(squareSize*2, 160)
    removeGrid()
    drawGrid()
  }

  // Increases the zoom
  def zoomIn(): Unit = {
    zoomState match {
      case 1  => zoomState = 2
      case 2  => zoomState = 5
      case 5  => zoomState = 10
      case 10 => zoomState = 20
      case 20 => zoomState = 40
      case _ =>
    }

    removeGrid()
    drawGrid()
    diagramVisualizer.updateLines()
  }

  // Decreases the zoom
  def zoomOut(): Unit = {
    zoomState match {
      case 40 => zoomState = 20
      case 20 => zoomState = 10
      case 10 => zoomState = 5
      case 5  => zoomState = 2
      case 2  => zoomState = 1
      case _ =>
    }

    removeGrid()
    drawGrid()
    diagramVisualizer.updateLines()
  }


}
