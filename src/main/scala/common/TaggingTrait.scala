package common

/**
  * Created by Zing on 2017/7/24.
  */
object TaggingTrait extends App {

  def display(c: Color) = c match {
    case Red => s"It's $c"
    case Green => s"It's $c"
    case Blue => s"It's $c"
  }

  println(Color.values.map(display))

}

//标记特征（此处是color）的标志是，它只是为了在公共名字之下聚集类型而存在，因此通常没有任何域或者方法。
//sealed 关键字表明除了在此处看到的Color的子类型之外，没有任何其他子类型
//case （case object）对象就像case类一样（case class）只是它产生的是对象而不是类

sealed trait Color

case object Red extends Color

case object Green extends Color

case object Blue extends Color

object Color {
  val values = Vector(Red, Green, Blue)
}
