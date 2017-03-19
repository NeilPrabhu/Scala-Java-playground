object p7q2 {
  def main(args:Array[String]){
    def tst = (x:Int)=> x==3 || x==6 || x==12
    def tsf = (x:Int)=> x==3 || x==6 || x==5
    def tst2 = (x:Int)=> x==3 || x==6 || x==12
    def tsf2 = (x:Int)=> x==33 || x==66 || x==55
    def s1 = new Set(tst)
    def s2 = new Set(tsf)
    def s3 = new Set(tst2)
    def s4 = new Set(tsf2)
    // TEST CONTAINS
    println(s1.contains(12))
    println(s2.contains(12))
    // TEST UNION
    println(s1.\/(s2).contains(12))
    println(s1.\/(s2).contains(4))
    // TEST INTERSECTION
    println(s1./\(s2).contains(3))
    println(s1./\(s2).contains(5))
    // TEST DIFFERENCE
    println(s1.-(s2).contains(12))
    println(s1.-(s2).contains(5))
    // TEST FILTER
    println(s1.filter(tsf).contains(6)) // tsf is the set three six five
    println(s1.filter(tsf).contains(12))
    // TEST FORALL
    println(s1.forall(tsf)) // tsf is the set three six five
    println(s1.forall(tst2)) 
    // TEST EXISTS
    println(s1.exists(tsf)) // tsf is the set three six five
    println(s1.exists(tsf2)) // tsf2 is the set of 33 66 55
    // TEST MAP
    def square(x:Int):Int = x*x
    println(s1.map(square).contains(9))
    println(s1.map(square).contains(39))
  }
  class Set(f:Int=>Boolean){
    //the function f returns true for elements of the set and false for all other numbers
	def contains(elem: Int): Boolean = this.f(elem)
	//returns true if elem is in the set and false for all other numbers
	def \/ (t:Set):Set = new Set((x:Int) => t.contains(x) || this.contains(x))
	//Returns the union of this set and t.
	def /\ (t:Set):Set = new Set((x:Int) => t.contains(x) && this.contains(x))
	//Returns the intersection of this set and t
	def - (t:Set):Set = new Set((e2:Int)=> this.contains(e2) && !t.contains(e2))
	//Returns the difference of this set and t
	def filter(p:Int=>Boolean):Set = /\(new Set(p))
	// Returns a new set that consists of the elements of s that satisfy the predicate.
	def forall(p:Int=>Boolean):Boolean = { // this ==  new Set((x:Int) => (x > -1000 && x < 1000)) 
	  def itr(x: Int):Boolean = {
	    if (x == -1000) true
	    else if (this.contains(x) && filter(p).contains(x)) false
	    else itr(x-1)
	  }
	  itr(1000)
	}
	//Returns true if the predicate is true for all elements of this set, and false otherwise.
	// In order to make it possible to implement this function, we will consider a predicate true for all integers if it is true for integers from -1000 to 1000.
	def exists(p:Int=>Boolean):Boolean = {
	  def itr(x: Int):Boolean = {
	    if (x == -1000) false
	    else if (this.contains(x) && filter(p).contains(x)) true
	    else itr(x-1)
	  }
	  itr(1000)
	}
	//Returns true if there is at least one item in the set for which the predicate p is true.
	// In order to make it possible to implement this function, we will consider a predicate true for all integers if it is true for integers from -1000 to 1000.
	def map(g:Int=>Int):Set = new Set((x:Int) => exists((y:Int)=> g(y) == x))
	//Returns a new set where each element of this set is mapped to the new set by the function g. a. You MUST use an anonymous function.
	//For example, if the function is x=>x*x, and 4 is in this set, then 16 should be in the mapped set. Hint: you can use other methods you’ve already defined.
	}
}