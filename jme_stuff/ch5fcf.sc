// in functional programming, the function should shoud be first class.
/* what is first class function?
	- the function can be used in every segment of the language.  
	- be created in lteral form without having assigned an identifier.	
	- be stored in container like value or variable, or data structures.
	- be used as parameter to other functions

in short, i should be able t use the first class function like a value or variable.

what are higher ordr functions?

functions that take other functions as parameter or use functions as return values are called higher order functions

example of higher order functions: map(), reduce().  
using a combination of higher order functions in a framework and allowing the users of the framework to declare what needst be done. The higher order function will manage the program flow.

this sort of programming concept is called: Declarative Programming.

*/

// Function Types and Values
// ([<type>, ...]) => <type>

// assume double is just an identififer name.
// note the real thing that distinquishes the function is its input types and output types
// (Int) => Int   <- meaning, (Int) is function input is => Int is the output.

def double  (x: Int): Int = x * 2  
double(5)

// now we define a val for the function and use the val to invoke the function
val myDouble: (Int) => Int = double  // this is how i am going to declare to use fn as a val.
myDouble(5)

val myDoubleCopy = myDouble // val to val is simple assignment
myDoubleCopy(10)

// easier way to assign a function to a value is by using the _
// val <identifier> = <function name> _

val myDouble2 = double _  // here i am not using (Int) => Int formation in syntax.
			  //without the _ the compiler will thing it is a function invocation.

val amt = myDouble(4)

// what if there is more than one input parameters?

def max(a: Int, b: Int) = if (a > b) a else b
val maximize: (Int, Int) => Int = max
maximize(50, 30)

// And what if there is no parameter?

def logStart() = "=" * 50 + "\nStarting NOW\n" + "=" * 50

val start: () => String = logStart

println(start())

///// HIGHER ORDER FUNCTION /////
def safeStringOp(s: String, f: String => String) = {
	// the f is passed as a parameter.  Check how the parameter is defined.
	if (s != null) f(s) else s
}

def reverser(s: String) = s.reverse

// let us use reverser using a hiher order fn safeStringOp
var rev_str = safeStringOp(null, reverser)  // so reverser does not raise nullPointException
rev_str = safeStringOp("Hello There", reverser) 

////// FUNCTION LITERALS ///////
// ([<identifier>: <type>, ... ]) => <expression>

/* function literals are known with many names.
	anonymous function and function literals : official scala term
	lambda expressions or lambdas : jsued by c# java etc
	The idea: the function type (input and ouptput type) and the definition are all in line.

Key point to learn here:  Understand the difference between:
	a function vs. function value vs function literal. 

*/

def max_fn(a: Int, b: Int) = if (a > b) a else b	//function
val maximize_fnval: (Int, Int) => Int = max 	// function value: is like a pointer to max func.
val maximize_fnlit = (a: Int, b: Int) => if (a > b) a else b // function literal with body and all.


val fn_res = max_fn(10, 12)	// shoudl return 12
val vl_res = maximize_fnval( 12, 9) // return 12
val lt_res = maximize_fnlit( 3, 12) /// return 12

val doubler = (x: Int) => x * 2
doubler( 30 )

// let us now call the higher-order safeStringOp passing in lteral function
val lit_reverser = (s: String) => s.reverse // literal fn assinged to reversion val
// the value lt_reverser fn is passed to safeStringOp
safeStringOp("Ready Lit_rev", lit_reverser) 

// why use value! pass literal directly! 
//	for me this is lesse difficult to understand compared to simpler form below

safeStringOp("Ready Lit Dir", (s: String) => s.reverse ) 

//okay let us use a simpler syntax for the literal function
//	for me the simpler form is more difficult to understand 

safeStringOp("Ready Lit Dir simple", s => s.reverse ) 

////// PLACEHOLDER SYNTANX ////////

// look at : val doubler = (x: Int) => x * 2
// redefine with  placeholder syntax

val doubler2 : Int => Int = _ * 2
doubler2(34)

//look at the following
//look at this: safeStringOp("Ready Lit Dir", (s: String) => s.reverse ) 
//the the same experessed with placehokder syntax below
safeStringOp("Ready Lit Placeholder synt", _.reverse ) 

// f(x,y) will be called by combination fn where f(x,y) is a function that takes two int arg
def combination(x: Int, y: Int, f: (Int,Int) => Int) = { if ( x >= 0 & y >= 0 ) f(x,y) else -1}

//letus invoke combination
combination( 2, 3, _ * _ )  // f(x,y) here f is multiplication 
combination( 2, 3, _ / _ )  // f(x,y) here f is division 

val makeit = (x: Int, y: Int) => {if (x > y) x else y}
combination(5, 2, makeit )

// this works because i am not using placeholders
combination(5, 2,   (x: Int, y: Int) => if (x > y) x else y ) 

//it works as long as these _ and _ are a binary op and  no aditional stmts as part of the logic.
combination(5, -2,  _ + _  )  // expecting -1 as ret val 


//////// PARTIALLY APPLIED FUNCTIONS //////////
def factorOf(x: Int, y: Int) = y % x == 0
factorOf(3, 27)

val f = factorOf _
f(3, 36)

// so if my use case is to check whether 3 is the factor of any given numner i can keep 3 constant.
val factorOfThree = factorOf(3, _: Int) 
factorOfThree(34) 	//takes in only one argument compared to factorOf.  So partially applied. 
factorOfThree(35)
factorOfThree(36)

/* in general sense, it it were in a c program or old java program, we would have it done like:

c program:

	#include <stdbool.h>
	#include <stdio.h>
	
	
	bool factorOf(int x, int y);
	bool factorOfThree( int n );
	
	int main(){
	
		bool x = false;
		x = factorOfThree(34); printf("input 34. Res: %d\n", x);
	        x = factorOfThree(35); printf("input 35. Res: %d\n", x);
	        x = factorOfThree(36); printf("input 36. Res: %d\n", x);
	}
	
	bool factorOf(int x, int y){
		return ( y % x == 0 );
	}
	
	bool factorOfThree( int n ){
		return factorOf(3, n);
	}
	
the results would be the same.
however, with this feature in scala, it become much faster to do simple things like this.
For example, what if i want to check if the numher is even?

*/

val isEven = factorOf (2, _: Int)
isEven(33)
isEven(34)
isEven(35)

///////// FUNCTION CURRYING ///////////
/* 
A better way to do this partially applied function is by using parameter groups to achieve the partially applied function.  This is called currying.

*/

def gFactorOf(x: Int)(y: Int) = y % x == 0
val gFactorOfThree = gFactorOf(3) _
val gIsEven = gFactorOf(2) _

gIsEven(33)
gIsEven(34)
gIsEven(35)
gFactorOfThree(34)
gFactorOfThree(35)
gFactorOfThree(36)


//////// BY NAME PARAMETERS //////

// <identifier>: => <type>

def doubles(x: => Int) = {	//defining this way can take a value or a func as arg
	println("Now doubling " + x)
	x * 2
}

def f(i: Int) = { println(s"Hello from f($i)"); i }

//both these function calls work because x is defined as named param in doubles fn: (x: => Int)

doubles(f(8)) 
doubles(8) 

println(" /////// PARTIAL FUNCTION ////////")

/////// PARTIAL FUNCTION ////////
/* So what is the difference between partially applied funciton and partial fuction?

A partial function, as opposed to a total function, only accepts a partial amount 
of all possible input values. See function below.  what will happpen if input is 201? 
An exception will be raised. So technically it is partial function 
if all possible inputs are not pproperly handled.

A partially applied function is a regular function that has been partially invoked, 
and remains to be fully invoked (if ever) in the future.
*/

val statusHandler: Int => String = {
	case 200 => "Okay"
	case 400 => "Your Error"
	case 500 => "Our error"
}


statusHandler(200)

// statusHandler(201) //will error out because the input is not handles.

println("//////// INVOKE HIGHER ORDER FUNCTION AND LITERAL FUNCTIONS BLCK //////")

//////// INVOKE HIGHER ORDER FUNCTION AND LITERAL FUNCTIONS BLCK //////

def fnSafeStringOp(s: String, f: String => String) = {  
	// work on it only if not null
	if (s != null) f(s) else s
}

println("getting uuid")
val uuid = java.util.UUID.randomUUID.toString // let us get a uuid

//and convert it into uppercase.

// val timedUUID = fnSafeStringOp (uuid, {s =>  // line errs with that space before paranthesis!

// original way
val timedUUID = fnSafeStringOp(uuid, {s =>  // this works
	//println("in fnsafe invok..")  
	// this code is not workign without this printlnln!! why?
	val now = System.currentTimeMillis
	val timed = s.take(24) + now  // take the first 24 chars
	timed.toUpperCase 
	}
 )

// this is a better syntax: see we used the parameter grouping.  it is cleaner.
def fn2SafeStringOp(s: String) (f: String => String) = {  
	// work on it only if not null
	if (s != null) f(s) else s
}

val timedUUID2 = fn2SafeStringOp(uuid) { s =>
	val now = System.currentTimeMillis
	val timed = s.take(24) + now
	timed.toUpperCase
}

// use by-name parameter way:
def timer[A](f: => A): A = { //f is defied as by-name parameter
	def now = System.currentTimeMillis
	val start = now; val a = f; val end = now
	println(s"Executed in ${end - start} ms")
	a
}

// the timer function 
val veryRandomAmount = timer {
	util.Random.setSeed(System.currentTimeMillis)
	for (i <- 1 to 100000) util.Random.nextDouble //just run and ignore a 100000 times.
	util.Random.nextDouble // this gets returned
}





//// end of ch
