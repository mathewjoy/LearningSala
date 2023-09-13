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

// how to invoke with expression when there are more than one arg?  Don't know.  
def greet2( x: Int, y: String): String = y * x

//the following invocation does not work for the above fn with two args
/*
greet { val abc = 16/3; abc, "Hello" }

*/


// recursive optimized w/ annotaction not to run over heap size
// the recurse call has to be the last line of the code to for this to work.
// refer to power() function above and compare to this
// this seems to be too complicated to for all practical purposes.
// Best thing is: avoid recursive function.  
// Actually the need for recursivenss can be avoided in most cases.
@annotation.tailrec
def power2(x: Int, n: Int, t: Int = 1): Long = {
	if (n == 0 ) return 1
	else power2(x, n-1, t*x)  //return this
}

println(power(2,10))

// nested functions

def max(a: Int, b: Int, c: Int) = {
	// define a nested fn below
	def max(x: Int, y: Int) = if (x > y) x else y

	// use the nested fn
	max(a, max(b, c))
}

val mx = max(100, 9, 3433)
println(mx)

// named parameters
def greet3(prefix: String, name: String) = s"$prefix $name"

println(greet3("Mr.", "Joey"))

// now named
println(greet3(name = "Joey", prefix ="Mr."))

// params with default value
def greet4(name: String, prefix: String = "") = s"$prefix$name"
println(greet4("Jessy")) // second param default val
println(greet4(name = "Jessy")) // second param default val

//varargs
def sum(items: Int*): Int = {
	var total = 0
	for (i <- items) total += i
	total
}

val s = sum( 1, 5, 8)
println(s) 

// parameter groups - it looks really crazy
def max3(x: Int)(y: Int) = if (x > y) x else y

val mx3 = max3(34)(23)
println(mx3) 

// parameter groups - can it take varargs?? 
def max4(x: Int*)(y: String*): Tuple = {
	val mxstr : String = {
		var s : String = ""
		for (i <- y ) if ( s < i ) s = i
		println("max str " + s)
		s // return from the block gets assigned to mxstr
	}

	val mx: Int = {
		var a : Int = 0
		for ( i <- x ) if (a < i) a = i
		println(":" + a)
		a // return from the block gets assined to mx
	}

	( mx, mxstr ) // return the tuple to the caller
} 

val mx4 = max4(34, 23, 2)("Hello", "There")
println("::"+ mx4) 

//Function Type Parameters

def identity(a: Any): Any = a
// the following fail because the function returns Any trying to assign to String!
//val s1: String = identity("Hello")


// define with the Type template. 

// defining A to be the type template
// but if you try to do complex operations on a like multiply with a with a double - Fails!!
def identity1[A](a: A): A = a 
// String below gets mapped to template type A
val str1 : String = identity1[String]("Hello") // String maps to template type A in def
val dbl1 : Double = identity1[Double](235.34) // Doble maps to teplate type A

//well try omit the explict mention of type and see what happens.
val dbl2 : Double = identity1(235.34) //the type of the arg Double maps to template type A

//Int gets assigned to double
val any1 : Double = identity1(34343) //the type of the arg Int maps to template type A

// method invocation types: Infix dot notation and operator notation.
// <class instance>.<method>[(<parameters>)] vs <object> <method> <parameter> .
// the operator style of method invocation looks pretty lame.  avoid it.
// and the operator style can be used only with functions with sinlge parameter.

val d: Double = 2.5
val cmp1 = d.compare(23) 		//infix dot notation
val cmp2 = d compare 25			//operator notation: the method acts like an operator 


/// document your code.  Use javadoc style

/**
 * Returns the input string without leading or trailing
 * whitespace, or null if the input string is null.
 *
 * @param s the input string to trim, or null.
 */
def safeTrimxxx(s: String): String = {
	if (s == null) return null
	s.trim()
}


