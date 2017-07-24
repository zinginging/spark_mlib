package common

/**
  * Created by Zing on 2017/7/19.
  */
/*
scala的object关键字定义了大体上与类相同的事物，只是不能创建object的任何实例，它是唯一的，object提供了一种方式，
把在逻辑上彼此紧密关联但是无需多个实例的方法和域收集在一起。它只有一个实例，那就是它自己
大写object名字的首字母，因为它既表示类，又表示实例。
 */
object YieldTest {

  def main(args: Array[String]): Unit = {

    case class LongabcdHadfsdfsdffgf(a: String)
    val v = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)

    /*println(yielding1(v))
    println(yielding2(v))
    println(yielding3(v))
    println(yielding4(v))*/

    //在名字太长或者太难用，可以使用type关键字对现有名字起一个新名字作为别名
    type short = LongabcdHadfsdfsdffgf

    val a = new short("b")
    print(a.a)

    val ab = Vector(1,2,3,4)
    println(ab.size)

  }



  def yielding1(v: Vector[Int]): Vector[Int] = {
    val result = for {
      n <- v
      if n < 10
      if n % 2 == 0
    } yield n
    result
  }

  def yielding2(v: Vector[Int]): Vector[Int] = {
    for {
      n <- v
      if n < 10
      isOdd = (n % 2 != 0)
      if (isOdd)
    } yield n
  }

  def yielding3(v: Vector[Int]): Vector[Int] = {
    for {
      n <- v
      if n < 10
      if n % 2 != 0
    } yield {
      val u = n * 10
      u + 2
    }
  }

  def yielding4(v: Vector[Int]) = {
    for {
      n <- v
      if n < 10
      if n % 2 != 0
    } yield {
      for (u <- Range(0, n))
        yield u
    }
  }

  //去掉不必要的花括号：如果一个方法由单个表达式构成，那么环绕该方法的花括号就不是必须的
  def yielding5(v: Vector[Int]): Vector[Int] =
    for {
      n <- v
      if n < 10
      if n % 2 != 0
    } yield n

}
