package GUI

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.layout.{Background, BackgroundFill, ColumnConstraints, CornerRadii, FlowPane, GridPane, HBox, RowConstraints, VBox}
import scalafx.scene.paint.Color.Gray
import scalafx.Includes._
import buttons._

object GUIApp extends JFXApp{
 // Setting up the GUI here

 // GUI takes inspiration from one of the "ScalaFX-tutorial" examples
  val root = new GridPane()
  val sce = new Scene(root)


  // Used to divide the window into multiple "zones"
  val column0 = new ColumnConstraints
  val column1 = new ColumnConstraints
  val column2 = new ColumnConstraints
  val row0 = new RowConstraints
  val row1 = new RowConstraints


  // Defining the percentages used in dividing the window.
  column0.percentWidth = 16
  column1.percentWidth = 44
  column2.percentWidth = 40
  row0.percentHeight = 84
  row1.percentHeight = 16

  // Initializing the stage
  stage = new PrimaryStage{
    title.value = "Diagram Visualizer"
    width = 1200
    height = 700
    scene = sce
  }

  val bottomBox = new HBox
  val sideBox = new VBox
  val buttonBox = new FlowPane

  // canvas is where the grid etc is drawn
  val canvas = new Canvas(1220, 760)

  // diagramcanvas is like canvas, but for diagrams
  val diagramCanvas = new Canvas(1220, 760)


  // Define the locations of various boxes
  root.add(sideBox, 0, 0, 1, 2)
  root.add(canvas, 1, 0)
  root.add(bottomBox, 1, 1, 1, 1)
  root.add(diagramCanvas, 1, 0)
  root.add(buttonBox, 2, 1, 1, 1)


  // Defining column and row constraints
  root.columnConstraints = Array[ColumnConstraints](column0, column1, column2)
  root.rowConstraints = Array[RowConstraints](row0, row1)


  // Setting various graphical settings.
    sideBox.background = new Background(Array(new BackgroundFill((Gray), CornerRadii.Empty, Insets.Empty))) //Set sideBox background color
  bottomBox.background = new Background(Array(new BackgroundFill((Gray), CornerRadii.Empty, Insets.Empty))) //Set bottomBox background color
  buttonBox.background = new Background(Array(new BackgroundFill((Gray), CornerRadii.Empty, Insets.Empty)))

  // Adding the buttons and text fields.
  sideBox.children += nameField
  sideBox.children += (lineDiagramButton, resetButton)
  sideBox.children += (gridToggler, decreaseSquareSizeButton, increaseSquareSizeButton)
  sideBox.children += (zoomGridInButton, zoomGridOutButton)
  bottomBox.children += xAxisName
  sideBox.children += yAxisName


  grid.toggleGrid()
  stage.setFullScreen(true)
}
