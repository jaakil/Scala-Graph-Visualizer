import diagrams.lineDiagram
import org.scalatest.flatspec.AnyFlatSpec
import scalafx.scene.paint.Color._

class lineDiagramTest extends AnyFlatSpec {
  "A lineDiagram" should "contain the right values " in {
    val ld = new lineDiagram
    ld.addData(1,3)
    ld.addData(2,4)
    assert(ld.dataArray(0)._1 === 1)
    assert(ld.dataArray(0)._2 === 3)
    assert(ld.dataArray(1)._1 === 2)
    assert(ld.dataArray(1)._2 === 4)
  }

  "it also" should "sort the values correctly when added out of order in terms of the x-value" in {
    val ld = new lineDiagram
    ld.addData(2,4)
    ld.addData(1,3)
    assert(ld.dataArray(0)._2 === 3)
  }

  "a linediagram" should "have its name and color be updated correctly" in {
    val ld = new lineDiagram
    ld.color = Blue
    ld.setName("test")
    assert(ld.color === Blue)
    assert(ld.color !== Black)
    assert(ld.name === "test")
  }
}
