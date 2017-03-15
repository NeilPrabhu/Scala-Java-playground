object p6q3 {
	def main(args: Array[String]): Unit = {
	  def l1 = List(1,2,3,4)
	  println("l1: " + l1)
	  def l2 = List(7,8,9,10,11,12)
	  println("l2: " + l2)
	  def testAnon(xs:List[Int],f: Int=>Boolean):List[Int] = {
	    if(xs.isEmpty) Nil
	    else if(f(xs.head)) xs.head :: testAnon(xs.tail,f)
	    else testAnon(xs.tail,f)
	  }
	  println()
	  println("result: " +testAnon(l1,(x) => x%2 == 0))
	  println("result 2: " +testAnon(l2,(x) => x>10))
	}
}