object myProgram {
	def main(args: Array[String]): Unit = {
			println("scala rocks")
			def a = 10; // does not let you re-assign var (a)
			println(a)
			def square(x:Double) =  x*x // function equals a value x*x
			def square2(x:Int) = {
				println(x)
				x*x
			}
			println(square(a)) 
			def first(x1:Int, x2:Int) = x1
			println(first(1000,2000))
			def abs(x:Double) = if(x > 0) x else -x
			println(abs(-20))
			println(abs(2))
			
			def sqrt(x:Double) = {
			  def sqrtIter(guess:Double):Double = {
			    if(abs(square(guess)-x) <= 0.001)
			       guess
			    else
			      sqrtIter((guess +x/guess) / 2)
			  }
			  sqrtIter(1.0)
			}
			
	}
}