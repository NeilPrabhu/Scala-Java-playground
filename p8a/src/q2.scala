object q2 {
  def main(args: Array[String]): Unit = {
    def tst = (x:Int)=> x%2 == 0
    def s1 = new Set(tst)
    def s2 = new singletonSet(3)
    def s3 = new singletonSet(4)
    def s4 = new rangeSet(20,30)
    
    println(s2.forall(tst))
    println(s3.forall(tst))
    println(s4.forall(tst))
    println(s4.exists(tst))
    
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

	class singletonSet(elem:Int) extends Set((x:Int) => x==elem){ 
	  def s = new Set((x:Int) => x==elem)
	  //This class creates a set with only one element, elem.
	  //Now that we have a set with only one element, we can do better with //forall and exists. Implement these functions to work for ALL integers, //not just those in the range -1000 to 1000
	  override def forall(p:Int=>Boolean):Boolean = {  
	    if(p(this.elem)) true
	    else false
	  }
	  override def exists(p:Int=>Boolean):Boolean = {
	    if(this.contains(elem) && p(elem)) true
	    else false
	  }
	}
	class rangeSet(start:Int, end:Int) extends Set((x:Int) => x>=start && x<=end) 
	{
	  def s = new Set((x:Int) => x>=start && x<=end)
	  //This class creates a set whose elements are all integers between start and end, inclusive.
	  //Now that we have a set with a finite number of elements, we can do better with //forall and exists. Implement these functions to work for ALL integers,
	  //not just those in the range -1000 to 1000
	  override def forall(p:Int=>Boolean):Boolean = {
	    def forthis(x:Int):Boolean = {
	      if(x > end) true
	      else
	        if(this.contains(x))
	          if(p(x)) forthis(x+1)
	          else false
	        else forthis(x+1)
	    }
	    forthis(start)
	  }
	  override def exists(p:Int=>Boolean):Boolean = {
	    def forthis(x:Int):Boolean = {
	      if(x > end) false
	      else
	        if(this.contains(x) && p(x)) true
	        else forthis(x+1)
	    }
	    forthis(start)
	  }
	}
}