object p9q1 {
  def main(args:Array[String]){
  	val t = new Node(5, Leaf, Leaf)           
	val t2 = t insert 8 insert 4 insert 9     
	t2 member 8                               
	t2 member 2                               
	
	val t3 = Leaf                             
	val t4 = t3 insert 1 insert 10 insert 12 insert 2
    val t5 = Leaf insert 1 insert 10 insert 12 insert 2  
    val t6 = Leaf insert 1 insert 10 insert 12 insert 2
	t4 merge t2   
	println(t4 equal t5)
  	println(t3.exactsubtree(t4))
  	println(t4.exactsubtree(t6))
  	println(t4.exactsubtree(t2))
  }
}
/*
 * To define equal, I need to know whether the input is a Leaf or a Node.  
This is where pattern matching comes in.
If I define classes as case classes, then I can use the match structure to test which constructor was used to create the object
Kind of like a switch statement, but for objects
 * 
 */
abstract class BSTree{
	def member(x: Int): Boolean
	def insert(x: Int): BSTree
	def merge(other:BSTree): BSTree
	def equal(other:BSTree): Boolean
	def exactsubtree(that:BSTree):Boolean
}
case object Leaf extends BSTree{
	def member(x:Int): Boolean = false
	def insert(x: Int): BSTree = new Node(x, Leaf, Leaf)
	override def toString = "."
	def merge(other:BSTree): BSTree = other
	def equal(other:BSTree): Boolean ={
	  other match{
	    case Leaf => true
	    case Node(_, _, _) => false
	  }
	}
	def exactsubtree(that:BSTree):Boolean={
	  that match{
	    case Leaf => true
	    case Node(_, _, _) => true
	  }
	}
	
}
case class Node(value: Int, left: BSTree, right: BSTree) extends BSTree{

	override def toString = "{" + left.toString + value.toString + right.toString + "}"
	def member(x: Int): Boolean =
		if(value == x) true
		else if (x < value) left.member(x)
		else right member x
	
	def insert(x: Int): BSTree = {
		if(x < value) new Node(value, left insert x, right)
		else if (x > value) new Node(value, left, right insert x)
		else new Node(value, left, right)	//this
	}
	
	def merge(other:BSTree): BSTree =
		(((left merge right) merge other) insert value)
	
	def equal(other:BSTree): Boolean ={
	  other match{
	    case Leaf => false
	    case Node(va, le, ri) => (va==value) && (le equal left) && (ri equal right)
	  }
	}
	def exactsubtree(that:BSTree):Boolean = {
	  that match {
	    case Leaf => false
	    case Node(va,le,ri) => 
	      if(va == value) (le equal left) && (ri equal right)
	      else if(va > value) exactsubtree(ri)
	      else exactsubtree(le)
	  }
	}
}