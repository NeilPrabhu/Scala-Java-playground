object setsabstractclass {
  def main(args: Array[String]): Unit = {
	//val t = new BSTree
	//t.member(5)
	//Can't create an object whose type is an abstract class
	def t = new Node(5, Leaf, Leaf)           //> t  : Node = {.5.}
	val t2 = t insert 8 insert 4 insert 9     //> t2  : BSTree = {{.4.}5{.8{.9.}}}
	t2 member 8                               //> res0: Boolean = true
	t2 member 2                               //> res1: Boolean = false
	
	val t3 = Leaf                             //> t3  : Leaf.type = .
	val t4 = t3 insert 1 insert 10 insert 12 insert 2
                                                  //> t4  : BSTree = {.1{{.2.}10{.12.}}}
	print(t2.max)                               //> res2: BSTree = {{{{.1.}2.}4.}5{.8{.9{{.10.}12.}}}}
  }
  abstract class BSTree{
    def member(x: Int): Boolean
    def insert(x: Int): BSTree
    def merge(other:BSTree): BSTree
    def depth:Int
    def max:Int
  }
  object Leaf extends BSTree{
	def member(x:Int): Boolean = false
	def insert(x: Int): BSTree = new Node(x, Leaf, Leaf)
	override def toString = "."
	def merge(other:BSTree): BSTree = other
	def depth:Int =  1
    def max:Int = 0
  }
  class Node(value: Int, left: BSTree, right: BSTree) extends BSTree{
    override def toString = "{" + left.toString + value.toString + right.toString + "}"
	def member(x: Int): Boolean = {
		if(value == x) true
		else if (x < value) left.member(x)
		else right member x
    }
	def insert(x: Int): BSTree = {
	  if(x < value) new Node(value, left insert x, right)
	  else if (x > value) new Node(value, left, right insert x)
	  else new Node(value, left, right)	//this
	}
	def merge(other:BSTree): BSTree = (((left merge right) merge other) insert value)
	
	def depth:Int = {
	  def helper(n:BSTree,d:Int):Int = {
	  	if(this.left == Leaf && this.right == Leaf) d // if l and r are leaf then return depth
	  	else 
	  	  if(this.left == Leaf && this.right != Leaf) helper(this.right,d+1) // if l is leaf and r isn't recurse right and add 1 to depth
	  	  else helper(this.left,d+1)                                         // else recurse left
	  }
	  if(this.left == Leaf && this.right == Leaf) 1
	  else if(helper(this.left,0) > helper(this.right,0)) helper(this.left,1)
	  else helper(this.right,1)
	}
	
	def max:Int = {
	  def helper(n:BSTree):Int = {
	    if(this.left == Leaf && this.right == Leaf) this.value
	    else helper(this.right)
	  }
	  helper(this.right)
	}
  }
}