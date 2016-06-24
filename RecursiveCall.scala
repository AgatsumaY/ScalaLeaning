object RecursiveCall extends App {
	var level = 0;
	val indicator = "- " //インデント明示

	def trace[T](fname: String, arg: Any*)(body: => T): T = {
	 	val args = arg.mkString(",")
	 	println((indicator*level) + level + ":" + fname + "(" + args + ")")
	 	level += 1
	 	val ret = body
	 	level -= 1
	 	println((indicator*level) + level + ":" + fname + " =" + ret)
	 	ret
	 } 

	 def fact(x: Int): Int = {
	 	trace("fact", x) {
	 		if (x == 1) 1
	 		else x * fact(x-1)
	 	}
	 }

	 println("階乗＝" + fact(5))
}