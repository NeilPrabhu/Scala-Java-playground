package prog1

object prog {
def main(args:Array[String]){

}
}

abstract class BSTree{
	def member(x: Int): Boolean
	def insert(x: Int): BSTree
	def merge(other:BSTree): BSTree
	def equal(other:BSTree): Boolean
}


case object Leaf extends BSTree{
	def member(x: Int): Boolean = false
	def insert(x: Int): BSTree = new Node(x, Leaf, Leaf)
	def merge(other:BSTree): BSTree = other
	def equal(other:BSTree): Boolean = {   // Pattern matching, a form of reflection
	  other match{
	    case Leaf => true
	    case Node(_,_,_) => false
	  }
	}
}

case class Node(value: Int, l: BSTree, r: BSTree) extends BSTree {
  def left = l
  def right = r
  def member(x: Int): Boolean = {
    if (x==value) true
    else if (x< value) left.member(x)
    else right member x
    //never need to return false
  }
   def insert(x:Int):BSTree = {//No duplicates
      if (x<value) new Node(value, left insert x, right)
      else if (x>value) new Node(value, left,  right insert x)
      else new Node(x, left, right)
      //or else this
    }
  def merge(other:BSTree):BSTree = (((left merge right) merge other) insert value)
    
  def equal(other:BSTree): Boolean = {
     other match{
	    case Leaf => false
	    case Node(va,le,ri) => (va==value) && (le equal left) && (ri equal right)
	  }
  }
}