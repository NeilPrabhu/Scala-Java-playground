object p9q3 {
  def main(args:Array[String]){
    
    def adjsublist(xs:List[Int]):List[List[Int]] = {
      def helper(ys:List[Int], y:Int,z:Int,t:Int):List[List[Int]] = { // ys is xs, y is index of start of last t length, start of next subset, t is length of subset
        if(z == y) 
          if(t == xs.length)  ys::Nil
          else ys.drop(z).take(t) :: helper(ys,y-1,0,t+1)
        else
          ys.drop(z).take(t) :: helper(ys,y,z+1,t)
      }
      helper(xs,xs.length-1,0,1)
    }
    def l = List(1,2,3,4)
    println(adjsublist(l))
  }
}
