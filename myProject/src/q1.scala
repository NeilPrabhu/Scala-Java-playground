/*object q1 {
  def main(args:Array[String]){   
    def range(xs:List[Int], start:Int, end:Int):List[Int] = {
      def helper(ys:List[Int], i:Int):List[Int] = {
        if(ys.isEmpty || i>end) Nil
        else if (i>=start && i<=end) ys.head::helper(ys.tail, i+1)
        else helper(ys.tail, i+1)
      }
      helper(xs, 0)
    }
    
    def average(xs:List[Int]):Int = {//return type should probably be double
      def helper(ys:List[Int], total:Int, num:Int):Int = {
        if(ys.isEmpty) total/num
        else helper(ys.tail, total+ys.head, num+1)
      }
      helper(xs, 0, 0)
      
    }
    def applyrange(xs:List[Int], start:Int, end:Int, f:Int=>Int):List[Int] = {
      def helper(ys:List[Int], i:Int):List[Int] = {
        if(ys.isEmpty) Nil
        else if (i>=start && i<=end) f(ys.head)::helper(ys.tail, i+1)
        else ys.head::helper(ys.tail, i+1)
      }
      helper(xs, 0)
    }
    
    class Point(first:Int, second:Int)  {
      def x = first
      def y = second
      def >(that:Point):Boolean = {
        if(x*x+y*y > that.x*that.x+that.y*that.y) true
        else false
      }
     def >=(that:Point):Boolean = {
        if(x*x+y*y >= that.x*that.x+that.y*that.y) true
        else false
     }
     def <(that:Point):Boolean = {
        if(x*x+y*y < that.x*that.x+that.y*that.y) true
        else false
      }
    def <=(that:Point):Boolean = {
        if(x*x+y*y <= that.x*that.x+that.y*that.y) true
        else false
      }
    def +(shift:Int):Point = {
        new Point(x+shift, y+shift)
      }
    }
    
    def double(f:Int=>Int):Int=>Int = {
      (x)=>f(f(x))
    }
    def compose(f:Int=>Int, g:Int=>Int):Int=>Int = {
      (x)=>f(g(x))
    }
    
    def dx = .01
    def smooth(f:Double=>Double):Double=>Double = {
      (x)=>(f(x)+f(x+dx)+f(x-dx))/3
    }
    def rangeSet(start:Int, end:Int):Int=>Boolean = {
      (x)=>(x>=start)&&(x<=end)
    }
   def repeat(f:Int=>Int, n:Int):Int=>Int = {
      if(n==1) (x:Int)=>f(x)
      else compose(f, repeat(f, n-1))
    }
    def repeat2(f:Int=>Int, n:Int):Int=>Int = {
      if(n==0) (x:Int)=>x
      else compose(f, repeat2(f, n-1))
    }
  }
}
*/