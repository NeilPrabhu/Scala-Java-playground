object sd4 {
	def main(args:Array[String]){
		val a = new Rational(1,2)
		println(a)
		def b = new Rational(3,4)
		println(b)
		a.+(b)
		//println(a+b)
		//println(a.negify)
		//println(a.*(b))
		//println(a.sub(b))
		// 1+3
		// 1.+3
		//println(a * b)
		def var1 = new Rational()
		//println(var1)
		def var2 = new Rational(6)
		//println(var2)
	}
}
class Rational(x:Int, y:Int){
  // stuff not in functions are initialized when object created/decl'd
  def this(z:Int)  = this(z,1)
  def this() = this(1,1)
  // GCD
  private def gcd(a:Int,b:Int):Int = {
    if(b == 0) a else gcd(b,a%b)
  }
  
  private val div =  gcd(x,y)
  val numer = x/div
  val denom = y/div
  
  def +(that:Rational):Rational = new Rational(this.numer*that.denom +that.numer*this.denom, this.denom*that.denom)
  override def toString() = numer + "/" + denom // don't have to include the this.
  // need to find a GCD by multiplying the two denominators together
  def *(that:Rational):Rational = new Rational((this.numer*that.numer),(this.denom*that.denom))
  //def unary_-:Rational = new Rational(-this.numer, this.denom)
  def negify:Rational = new Rational(-this.numer, this.denom)
  def sub(that:Rational):Rational = new Rational(this.numer*that.denom - that.numer*this.denom, this.denom*that.denom)
  def -(that:Rational):Rational = this.+(that.negify)
}
