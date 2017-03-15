object p5q1 {
	def main(args: Array[String]): Unit = {
	  def combine(x:List[Int], f: (Int,Int) => Int):Int = {
		if(x.isEmpty) 0
		else f(x.head, combine(x.tail, f))
	  }
	  def add(x:Int, y:Int) :Int = x+y
	  def ls = List(3, 5, 2, 7)
	  print(combine(ls,add))
	}
}