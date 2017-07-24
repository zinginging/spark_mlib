package common

import java.util.Date

import org.apache.commons.math3.stat.regression.SimpleRegression

/**
  * Created by Zing on 2017/7/24.
  */
object UseJava {

  def main(args: Array[String]): Unit = {
    val d = new Date()
    println(d.toString)

    val m = new SimpleRegression()
    m.addData(1, 1)
    m.addData(2, 1.1)
    m.addData(3, 0.9)
    m.addData(4, 1.2)

    println(m.getN)


  }
}
