import diagrams.pieDiagram
import org.scalatest.flatspec.AnyFlatSpec
import scalafx.scene.paint.Color._

class pieDiagramTest extends AnyFlatSpec {
  "a pie diagram" should "add data correctly" in {
    val pie = new pieDiagram
    pie.addData(5, "test", Blue)
    assert(pie.dataArray(0)._1 === 5)
    assert(pie.dataArray(0)._2 === "test")
    assert(pie.dataArray(0)._3 === Blue)
  }
}
