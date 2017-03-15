object oct26 {
	def main(args: Array[String]): Unit = {
	  // how to trace lists
	  println("Declaring Lists:")
	  def square(z:Int):Int = z*z;
	  def l1 = List(4,5,2,3)
	  println(l1)
	  def l2 = 4::l1 // "cons" -- base type on left, list on right  *KEY
	  println(l2)
	  def l3 = 5::4::3::2::1::Nil
	  println(l3)
	  def l4 = l2 ::: l3// append a list
	  println(l4)
	  
	  // func that takes in list of ints and returns a list consisting of squares of all the ints in the original list
	  println("Squaring Lists:")
	  def square_list(x:List[Int]):List[Int] = {
	    if(x.isEmpty) Nil
	    else square(x.head) :: square_list(x.tail)
	  }
	  println( "list 1 squared "+ square_list(l1))
	  
	  // function passed in to square list of ints
	  def f_list(y:List[Int], f: Int => Int):List[Int] = {
	    if(y.isEmpty) Nil
	    else f(y.head) :: f_list(y.tail,f)
	  }	  
	  println("list 1 squared "+ f_list(l1,square))
	  
	  // reverse
	  def r_list(z:List[Int]):List[Int] = {
	    if(z.isEmpty) Nil
	    else r_list(z.tail) ::: (z.head::Nil)
	  }
	  println("Reversing Lists:")
	  println("list 1 reversed "+r_list(l1))
	  def r2_list(z:List[Int], f: Int => Int):List[Int] = {
	    if(z.isEmpty) Nil
	    else r2_list(z.tail,f) ::: (f(z.head)::Nil)
	  }
	  println("list 1 reversed with squares "+r2_list(l1,square))
	  def r3_list(x:List[Int]):List[Int] = {
	    def reverseIter(in:List[Int], out:List[Int]):List[Int] = {
	      if(x.isEmpty) out
	      else reverseIter(in.tail, in.head::out)
	    }
	    reverseIter(x,Nil)
	  }
	  // function takes in list of list of Ints
	  // returns a list of the sums of the lists of Ints
	  println("Sum of elements in a List:")
	  def l5 = List(List(1,2,3),List(5,2,4), List(6,3,1))
	  def sum_lists(xs:List[List[Int]]):List[Int] = {
	    def sum(ys:List[Int]):Int= {
	      if(ys.isEmpty) 0
	      else ys.head + sum(ys.tail)
	    }
	    if(xs.isEmpty) Nil
	    else sum(xs.head) :: sum_lists(xs.tail)
	  }
	  println(sum_lists(l5))
	  
	  def f_list2(y:List[Int], f: Int => Int):List[Int] = {
	    if(y.isEmpty) Nil
	    else f(y.head) :: f_list2(y.tail,f)    // append not cons
	  }	 
	  def cube(x:Int):Int = x*x*x
	  // println(f_list2(l3,cube))
	  println("w/ anonymous function")
	  println(f_list2(l3, (x)=>x*x*x))  // anonymous function, more inputs can be put into the parenthesis
	  
	  def combine2(ys:List[Int], f: Int =>Int):List[Int] = {
	    if(ys.isEmpty) Nil
	    else f(ys.head) :: combine2(ys.tail,f)
	  }

	  def contains(s:Int=>Boolean, elem:Int):Boolean = s(elem)
	  // contains(set1,7)
	    
	  def singletonSet(elem:Int):Int=>Boolean = {
	    def output(e2:Int):Boolean = {
	      e2 == elem
	    }
	    output
	  }
	  def singletonSet2(elem:Int):Int=>Boolean = 
	    (x:Int) => x==elem
	  println("Do Sets contain a number:")   
	  def set7 = singletonSet(7) // set 7 is given the function output from above 
	  println(contains(set7,7))
	  println(contains(set7,8))
      println(contains(set7,1))
	    
	  def  negs(x:Int):Boolean = x<0  // tests if x is negative
	    
	  def neg7 = union2(negs,set7)
	  println(contains(neg7, 7))
	  print(contains(neg7,-5))
	    
	  // function takes in 2 sets and returns the set that is the union of those two sets
	    
	  def union(s1:Int=>Boolean, s2:Int=>Boolean):Int=>Boolean = {
	   def output(e2:Int):Boolean = {
	     //s1(e2) || s2(e2) 
	     contains(s1,e2) || contains(s2,e2)
	   }
	   output
	  }
	  // does same as union(s1:Int=>Boolean, s2:Int=>Boolean):Int=>Boolean
	  def union2(s1:Int=>Boolean, s2:Int=>Boolean):Int=>Boolean = (x:Int) => s1(x) || s2(x)
	    
	  // Other ways to represent some sets:
	  // 1. List of elements 
	  // 2. Scala Set (Built-In list class with no duplicates)
	    
	  // more functions for gen. sets 
	  // i.e intersections and differences
	    
	  def intersect(s1:Int=>Boolean, s2:Int=>Boolean):Int=>Boolean = (x:Int) => s1(x) && s2(x)
	    
	  def difference(s1:Int=>Boolean, s2:Int=>Boolean):Int=>Boolean =  (x:Int) => !s1(x) && s2(x) || s1(x) && !s2(x)
	    
	}
}