object p7q1 {
  def main(args:Array[String]){
    //Define a set by its characteristic function
	//Function that takes in an int, returns true if that number is in the set
	//false if it isn't
	
	def contains(s:Int=>Boolean, elem:Int):Boolean = s(elem)
	//contains(set1, 7)
	
    def union(s1:Int=>Boolean, s2:Int=>Boolean): Int=>Boolean = {//A function that generates sets - NOT a set
     def output(e2:Int):Boolean = {
	    //s1(e2) || s2(e2)
       contains(s1, e2) || contains(s2, e2)
	  }
	  output 
    }
    def union2(s1:Int=>Boolean, s2:Int=>Boolean): Int=>Boolean ={//A function that generates sets - NOT a set
      (e2:Int) => contains(s1, e2) || contains(s2, e2)
    }

    def intersect(s1:Int=>Boolean, s2:Int=>Boolean): Int=>Boolean = //A function that generates sets - NOT a set
      (e2:Int) => contains(s1, e2) && contains(s2, e2)
    
    def diff(s1:Int=>Boolean, s2:Int=>Boolean): Int=>Boolean = //A function that generates sets - NOT a set
      (e2:Int)=> contains(s1, e2) &&  !contains(s2, e2)

    
    // part a
    def contains2(s:List[Int], elem:Int):Boolean = {
      if(s.isEmpty) false
      else if(elem == s.head) true
      else contains2(s.tail,elem)
    }
    def setlist(xs:List[Int]):Int=>Boolean = (x:Int) => contains2(xs,x)
    def l1 = List(4,5,2,3)
    println(contains(setlist(l1),33))
    
    
    // part b
    def filter(s: Int=>Boolean, p:Int=>Boolean):Int=>Boolean = (x:Int) => 		        contains(s,x) && contains(p,x)
    def s = (x:Int) => x == 20 || x == 4 || x == 63  || x == 70 || x == 10
    def p = (x:Int) => x < 1000 && x > -1000  
    println(contains(filter(s,p),1001))
    
    
    // part c
    def forall(s:Int=>Boolean, p:Int=>Boolean):Boolean = {
      def itr(x: Int):Boolean = {
    	if(x == -1000) true
    	else if ((contains(s,x)) && (!contains(filter(s,p),x))) false
		else itr(x-1)
      }
      itr(1000)
    }
    println(forall(s,p))
  }
}