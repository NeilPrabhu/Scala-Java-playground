object p5q2 {
  def main(args: Array[String]): Unit = {
    def apply_combine(x:List[Int], f: (Int,Int) => Int, f2: Int => Int):Int = {
      if(x.isEmpty) 0
      else f(f2(x.head), apply_combine(x.tail, f, f2))
    }
    def square(x:Int) = x*x
    def add(x:Int, y:Int) :Int = x+y
    def ls = List(3, 5, 2, 7)                                                                                                                                                                                                                    
    print(apply_combine(ls, add, square))
  }
}