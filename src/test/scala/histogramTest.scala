import diagrams.histogram
import org.scalatest.flatspec.AnyFlatSpec

class histogramTest extends AnyFlatSpec {
  "A histogram" should "add data correctly" in {
    val histo = new histogram
    histo.addData(10, "test1")
    assert(histo.dataArray(0)._2 === "test1")
  }
  "a histogram" should "be sorted properly" in {
    val histo = new histogram
    histo.addData(10, "test1")
    histo.addData(20, "test2")
    histo.sortDescending()
    assert(histo.dataArray(0)._2 === "test2")
    histo.sortAscending()
    assert(histo.dataArray(0)._2 === "test1")
  }
}
