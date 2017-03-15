
object hello {
  def main(args:Array[String]){
	  	println("Welcome to Scala") 
	  	println(5+4*3)
	  	def a = 10
	  	println(a)
	  	def square (x:Double):Double = { //Specifying the return type for non-recursive functions is optional.
	  	  //println(x)
	  	  x*x//If more than one line, the value of the function is the last line.  Play with uncommenting and see what happens.
	  	//"hello"  
	  	}
	  	println(square(a))
	  	def first ( x1:Int, x2:Int)= x1
	  	def first2 ( x1:Int, x2:Int) = {x1}
	  	println(first(3, 6))
	  	println(first2(3, 6))
	  	def abs(x:Double) = if(x>0) x else -x
	  	
	  	println(abs(5))
	  	println(abs(-10))
	  	
	  	def fact(x:Int) = {//Making a recursive helper function that acts like a loop
	  	  def factIter(i:Int) : Int= {//i (parameter)is our looping variable  (MUST specify return type for recursive functions)
	  		  if(i==x) x//Last time through the loop; terminating the loop
	  		  else i*factIter(i+1)//body of the loop, with recursion taking the place of the accumulator variable
	  	  }
	  	  factIter(1)//Initialize i
	  	}
	  	println("fact(5):")
	  	println(fact(5))
	  	
	  	def sqrt(x:Double):Double = {
	  	  def sqrtIter(guess:Double):Double = {
	  	    if(abs(square(guess)-x)<.001) guess//Need to fix types of square and abs
	  	    else sqrtIter((guess+(x/guess))/2)
	  	  }
	  	  sqrtIter(1.0)
	  	}
	  	println("sqrt(9):")
	  	println(sqrt(9))
  }
}
