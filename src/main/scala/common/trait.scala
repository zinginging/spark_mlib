/**
  * Created by Zing on 2017/7/21.
  */
trait A {
  def f = 1.1

  def g = "A.g"

  val n = 7
}

trait B {
  def f = 7.7

  def g = "B.g"

  val n = 17
}


object C extends A with B {

  override def f: Double = super.f

  override def g: String = super[A].g + super[B].g

  override val n = 27

  def main(args: Array[String]): Unit = {
    //为何f此时是7.7
    println(f + ":" + g + ":" + n) //7.7:A.gB.g:27

  }


}
