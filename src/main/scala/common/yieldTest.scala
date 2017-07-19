package common

/**
  * Created by Zing on 2017/7/19.
  */
object yieldTest {

  def main(args: Array[String]): Unit = {
    val v = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
    println(yielding1(v))
    println(yielding2(v))
    println(yielding3(v))
    println(yielding4(v))


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


}
