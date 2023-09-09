// define a function
def multiplier(x: Int, y: Int): Int = { x * y }

multiplier(4, 5)

//
def safeTrim(s: String): String = {
	if (s == null) return null
	s.trim() // return this
}

println (safeTrim("  Lala Lal "))

// recursive
def power(x: Int, n: Int): Long = {
	if (n >= 1) x * power(x, n-1)  //return this
	else 1	// or return this1
}

println(power(2,6))

//invoke function with an expressioni
def greet( x: Int): String = "greet " * x

greet { val abc = 16/3; abc }


def greet2( x: Int, y: String): String = y * x

greet { val abc = 16/3; abc, "Hello" }


