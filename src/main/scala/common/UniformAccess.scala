package common

/**
  * Created by Zing on 2017/7/24.
  */

//object extends App与有main函数功能一样，使该脚本能够运行，使用main没有什么特别的原因，
// 只是因为它可以使得编写出来的代码对从其他编程语言（特别是java）转向scala的程序员来说显得很熟悉

object UniformAccess extends App {
  println(123)
}

trait Base {
  def f1: Int

  def f2: Int

  val d1: Int
  val d2: Int
  var d3: Int
  var n = 1

}

class Derived extends Base {
  def f1 = 1

  //统一访问原则：scala中，可以将无参数并且会返回结果的方法当做会产生同种类型结果的val处理
  //  反过来是不行的，如果基类型中有一个val，则不能使用def来实现它，val必须是稳定的且不可变更的值
  val f2 = 2 //之前为def，现在为val，可以这样用
  val d1 = 1
  //def d2 = 1  不能这样用，必须是val
  val d2 = 1

  //如果基类的域为var，可以使用def来实现，但是还需要一个设置setter，因为抽象的var要求除了getter之外，还需要有setter
  //setter形式：标识符后面跟 _=，并且只有单个参数，此时既可以通过def d3 = n方法读取变量，
  // 也可以通过def d3_=(newVal: Int) = n = newVal修改该变量
  def d3 = n

  def d3_=(newVal: Int) = n = newVal


}



