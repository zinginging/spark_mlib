package learn_mlib.RDDMethod

import org.apache.spark.{SparkConf, SparkContext}


/**
  * Created by Zing on 2017/7/19.
  */
object aggregateMethod {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("testAggregateMethod").setMaster("local[1]")
    val sc = new SparkContext(conf) //设置环境变量实例
    //parallelize方法是将内存数据转换为rdd
    val arr = sc.parallelize(Array("abc","a","b","c","d","e"))
    val arr1 = sc.parallelize(Array(1,2,3,4,5,6))
    val arr2 = sc.parallelize(Array(4,5,6))
    val result = arr1.cartesian(arr2)
    //println(result)
    //result.foreach(print)
    val re1 = arr1.flatMap(x => List(x,x+1)).collect()
    //re1.foreach(println)
    val re0 = arr1.map(x => List(x+1)).collect()
    //re0.foreach(println)
    val re = arr1.map(x => (x,1)).reduceByKey(_+_)

    //分组以函数确定分组的条件，第二个参数为分组的标签值
    //groupBy消耗资源较多，而且元素的排序不确定
    arr1.groupBy(myFilter(_)).foreach(println)
    //arr1.groupBy(myFilter2(_),2).foreach(println)
    //re.foreach(println)

    //arr.foreach(println)


  }

  def myFilter(num : Int): String ={
    if(num >= 3) "x" else "y"
  }
  def myFilter2(num : Int): Unit ={
    num < 3
  }
}
