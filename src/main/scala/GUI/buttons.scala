package GUI
import GUIApp._
import grid._
import diagramVisualizer._
import scalafx.scene.control.{Button, ColorPicker, TextField}
import scalafx.stage.FileChooser
import utilities.fileRead._
import diagrams._
import scalafx.scene.control.ColorPicker.sfxColorPicker2jfx
import scalafx.Includes._


object buttons {

  // Toggles the grid, as you can probably imagine
  val gridToggler = new Button("Toggle Grid")
  gridToggler.setOnAction(a => grid.toggleGrid())

  val decreaseSquareSizeButton = new Button("Decrease Square Size")
  decreaseSquareSizeButton.setOnAction(a => grid.decreaseSquareSize())

  val increaseSquareSizeButton = new Button("Increase Square Size")
  increaseSquareSizeButton.setOnAction(a => grid.increaseSquareSize())

  val zoomGridInButton = new Button("Zoom in")
  zoomGridInButton.setOnAction(a => grid.zoomIn())

  val zoomGridOutButton = new Button("Zoom out")
  zoomGridOutButton.setOnAction(a => grid.zoomOut())


  // A button for adding a line diagram
  val lineDiagramButton = new Button("New Line Diagram")
  lineDiagramButton.setOnAction(a => {
    val fileChooser = new FileChooser
    val selectedFile = fileChooser.showOpenDialog(GUIApp.stage)

    if(selectedFile != null){
      readFile(selectedFile, "line")
    }
  })


  // A button for adding a histogram
  val histogramButton = new Button("New Histogram")
  histogramButton.setOnAction(a => {
    val fileChooser = new FileChooser
    val selectedFile = fileChooser.showOpenDialog(GUIApp.stage)
    if(selectedFile != null){
      readFile(selectedFile, "histo")
    }
  })


  // A button for adding a pie diagram
  val pieDiagramButton = new Button("New Pie Diagram")
  pieDiagramButton.setOnAction(a => {
    val fileChooser = new FileChooser
    val selectedFile = fileChooser.showOpenDialog(GUIApp.stage)
    if(selectedFile != null){
      readFile(selectedFile, "pie")
    }
  })

  def createButtonsForLine(ld: lineDiagram): Unit = {
    // First we shall create a text box for the name of a line diagram
    val nameBox = new TextField
    nameBox.promptText = ld.name
    nameBox.setMaxWidth(120)
    nameBox.setOnAction(a => {
      var str = nameBox.getText
      ld.name = str
      updateLines()

    })
    // Place the name box
    buttonBox.children += nameBox


    // Next we shall create a button for choosing the color
    val colorButton = new ColorPicker(ld.color)
    colorButton.setOnAction(a =>{
      var c = colorButton.getValue
      ld.color = c
      updateLines()
    })
    // Place the created color button
    buttonBox.children += colorButton

  }

  // Button used to reset the application to its normal state.
  val resetButton = new Button("Reset")
  resetButton.setOnAction(a=> {

    // Makes everything have the default values
    grid.removeGrid()
    clearDiagram()
    lineDiagramsInArray = Array()
    currentHistogram = None
    squareSize = defaultSquareSize
    zoomState = 1
    diagramType = "line"
  })

  // Self explanatory text fields meant to allow the user to change the names and units of the axes.
  val nameField = new TextField
  nameField.promptText = "Diagram name"

  val yAxisName = new TextField
  yAxisName.promptText = "Y-axis name (Unit)"

  val xAxisName = new TextField
  xAxisName.promptText = "X-axis name (Unit)"




}
