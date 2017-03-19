object myq1 {
  def main(args:Array[String]){
	def average(xs:List[Int]):Int = {
	  def iter(ys:List[Int],elem:Int,total:Int):Int = {
	    if(ys.isEmpty) total/elem
	    else iter(ys.tail,elem+1,total+ys.head) 
	  }
	  iter(xs,0,0)
	}
	def l = List(12,31,23,14,1)
	println(average(l))
  }
}