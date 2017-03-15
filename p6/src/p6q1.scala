object p6q1 {
	def main(args: Array[String]): Unit = {
	  def l1 = List(1,2,3,4)
	  println("l1: " + l1)
	  def l2 = List(7,8,9,10,11,12)
	  println("l2: " + l2)
	  def alt(xs:List[Int], ys:List[Int]):List[Int] = {
	    if(xs.isEmpty && ys.isEmpty) Nil
	    else if(!xs.isEmpty && ys.isEmpty) xs.head :: alt(xs.tail, ys)
	    else if(xs.isEmpty && !ys.isEmpty) ys.head :: alt(xs, ys.tail)
	    else xs.head :: ys.head :: alt(xs.tail,ys.tail)
	  }
	  println()
	  println("result: " + alt(l1,l2))
	}
}