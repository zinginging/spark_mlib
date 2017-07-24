package common

/**
  * Created by Zing on 2017/7/24.
  */
trait Aerobic {
  val age: Int

  def minAerobic =.5 * (220 - age)

  def isAerobic(heartRate: Int) =
    heartRate >= minAerobic


}

trait Activity {
  val action: String

  def go: String

}

class Person(val age: Int)

class Exerciser(age: Int, val action: String = "Running",
                val go: String = "Run!") extends Person(age)
  with Activity with Aerobic

object Test{
  def main(args: Array[String]): Unit = {
    val bob = new Exerciser(44)
    println(bob.isAerobic(180))
    println(bob.isAerobic(80))
    println(bob.minAerobic)
  }
}

//特征将他们的功能与其他的对象进行结合，就像Exerciser将Aerobic and Activity and Person 结合起来


