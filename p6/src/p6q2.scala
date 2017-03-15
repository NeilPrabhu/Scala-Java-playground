object p6q2 {
	def main(args: Array[String]): Unit = {
	  def l1 = List(3,8,1,5)
	  println("l1: " + l1)
	  def l2 = List(12,6,23,1,8,4)
	  println("l2: " + l2)
	  def anon(xs:List[Int], ys:List[Int], f: (Int,Int) => Int):List[Int] = {
	    if(xs.isEmpty && ys.isEmpty) Nil
	  	else if(!xs.isEmpty && ys.isEmpty) Nil
		else if(xs.isEmpty && !ys.isEmpty) Nil
	  	else f(xs.head, ys.head) :: anon(xs.tail,ys.tail,f)
	  }
	  println()
	  println("result: " + anon(l1,l2,(x,y) => x+y))
	}
}