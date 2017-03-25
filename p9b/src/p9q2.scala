object p9q2 {
	def main(args:Array[String]){
	  def findlast(xs:List[Int], x:Int):Int = {
	    def helper(ys:List[Int], y:Int, r:Int):Int = { // y is used for indexing
	      ys match {								   // r is index occurrence (x)
	        case Nil => if(r == 0) -1 else r
	        case z::zs => if(z == x)  helper(zs,y+1,y) else helper(zs,y+1,r)
	      }
	    }
	    helper(xs,0,0)
	  }
	  def l = List(2,3,4,2,3) // 0 1 2 3 4
	  println(l)
	  println(findlast(l,5))
	  println(findlast(l,2))
	}
}