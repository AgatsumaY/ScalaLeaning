object HelloWorld {
	def main(args: Array[String]): Unit = {
		println("HelloWorld")
		println(Test("aaa")) 
		val u = new User2("mam", 200)
		User2.printUser(u)
	}
	def Test(arg: String): String = {
		arg + "sine"
	}

}