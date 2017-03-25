
object pm {
  abstract class Expression
  case class X() extends Expression
  case class Const(value : Int) extends Expression
  case class Add(left : Expression, right : Expression) extends Expression
  case class Mult(left : Expression, right : Expression) extends Expression
  case class Neg(expr : Expression) extends Expression

  def eval(expression : Expression, xValue : Int) : Int = 
    expression match {
	  case X() => xValue
	  case Const(value) => value
	  case Add(left, right) => eval(left, xValue) + eval(right, xValue)
	  case Mult(left, right) => eval(left, xValue) * eval(right, xValue)
	  case Neg(expr) => - eval(expr, xValue)
    }
  
  
  
    def remove(xs: List[Int], x: Int): List[Int] = {
      if (xs.isEmpty) Nil
      else if (xs.head == x) remove(xs.tail, x)
      else xs.head :: remove(xs.tail, x)
    }
  /*My mistake:  you can't use x in the case to match the head automatically.  You CAN 
   * do this with literal values like 5, but NOT with variables
  def remove2(xs: List[Int], x: Int): List[Int] = {
    xs match {
      case Nil => Nil
      case x::ys => remove2(ys, x)
      case y::ys => y::remove2(ys, x)  
    }                                  
  }
  * 
  */
    //You would do it like this:
 def remove2(xs: List[Int], x: Int): List[Int] = {
    xs match {
      case Nil => Nil
      case y::ys => if(y==x) remove2(ys, x) else y::remove2(ys, x)  
    }                                  
  }
//Note:  You CAN do
  def remove5(xs: List[Int]): List[Int] = {
    xs match {
      case Nil => Nil
      case 5::ys => remove5(ys) 
      case y::ys => y::remove5(ys)  
    }                                  
  }
 
 
    /*  
  def count(xs:List[Int], x:Int): Int = {
    xs match {
      case Nil => 0
      case x::ys => 1 + count(ys, x)
      case y::ys => count(ys, x)       
    }
  }
    */
  //This is what you would do:
 def count(xs:List[Int], x:Int): Int = {
    xs match {
      case Nil => 0
      case y::ys => if(y==x) 1 + count(ys, x) else count(ys, x)      
    }
  }
 
  //Note:  I COULD do:
 def count5(xs: List[Int]): Int = {
    xs match {
      case Nil => 0
      case 5::ys => 1 + count5(ys) 
      case y::ys => count5(ys)  
    }                                  
  }
 
  def main(args:Array[String]){
    val expr = Add(Const(1), Mult(Const(2), Mult(X(), X())))  // 1 + 2 * X*X

    println(eval(expr, 3))
    
    def ls = List(1, 5, 2, 3 , 23, 8, 2, 8, 6, 5, 3, 10)
  
    println(count(ls, 2))
    println(count5(ls))
    println(remove(ls, 2))
    println(remove2(ls, 2))
    
    println(ls.length)                                         
    println(ls.last)//returns the last item (the dual of head)                                           
    println(ls.init)//returns the rest of the list that isn't last (the dual of tail)                                           
    println(ls.reverse)                                      
    println(ls.drop(3))//The list without the first 3 elements                                      
    println(ls.take(3))//The list of JUST the first 3 elements                              
    val (ls3, ls4) = ls.splitAt(3)  //ls3 will hold the take, and ls4 will hold the drop
    println(ls3)
    println(ls4)
    
    
    //mergesort:
    //Recursively split the list in half, sort each half, then merge them.
    //merge:  Take two sorted lists, and merge them
    
      def msort(xs:List[Int]): List[Int] = {
      def merge(xs:List[Int], ys:List[Int]):List[Int] = {
        // merge sorted halves
        xs match {
          case Nil => ys
          case x::xs1 => ys match {
            case Nil => xs
            case y::ys1 => if(x < y) x::merge(xs1,ys) else y::merge(xs,ys1)
          }
        }
      }
      // divide the list in half
      if(xs.isEmpty) xs
      else if(xs.tail.isEmpty) xs
      else {
        val(r,l) = xs.splitAt(xs.length/2)    
        merge(msort(l),msort(r))
      }
    }
    
    val l = List(1,2,3,4,5,6)
    println(1/2)
    println(l.length/2)
   // println(msort(l))
  }

}


