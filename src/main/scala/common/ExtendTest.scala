package common

/**
  * Created by Zing on 2017/7/20.
  */

class House(val address: String, val state: String, val zip: String) {
  def this(state: String, zip: String) =
    this("address?", state, zip)

  def this(zip: String) =
    this("address?", "state?", zip)
}

class Home(address: String, state: String, zip: String, val name: String)
  extends House(address, state, zip) {
  override def toString: String = s"$name:$address,$state,$zip"
}

class VacationHouse(state: String, zip: String, val startMonth: Int, val endMonth: Int)
  extends House(state, zip)

class TreeHouse(val name: String, zip: String)
  extends House(zip)

object ExtendTest {


}