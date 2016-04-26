class User2(val name: String, val age: Int) {
	
}

object User2 {
	def printUser(user: User2) = {
		println(user.name + " " + user.age)
	}
}