package learn_mlib

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Zing on 2017/7/18.
  */
object testRDDMethod {
  def main(args: Array[String]) {
//    val conf = new SparkConf()  //创建环境变量
//      .setMaster("local") //设置本地化处理
//      .setAppName("testRddMethod")  //设置名称

    val conf = new SparkConf().setAppName("testRddMethod").setMaster("local[1]")
    val sc = new SparkContext(conf) //设置环境变量实例
    val arr = sc.parallelize(Array(1,2,3,4,5,6))
    val result = arr.aggregate(0)(math.max(_,_), _+_) //使用aggregate方法
    println(result)
  }

}
