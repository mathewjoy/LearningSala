//5.1

// the literal function
//the println is not needed; put in for debug/logging purposes
val flit_max = (x: Int, y: Int) => { println(s"x: ${x}, y: ${y} "); if (x > y) x else y }

//the regular function that uses the literal function
def fn_max(a: Int, b: Int, c: Int) : Int =
	flit_max(a, flit_max(b, c))

fn_max(1,3,5)

// here is the answer to 5.1: the hiher order function that uses a literal function
def fn_max_tup( t: (Int, Int, Int), f: (Int, Int) => Int  ): Int  = 
	f(t._1, f(t._2, t._3))

// here you see the literal function flit_max being passed as an argument.
fn_max_tup( (1, 3, 5), flit_max)


// 5.2
//literal function
val flit_min = (x: Int, y: Int) => {println(s"x: ${x}, y: ${y} ") ;  if (x < y) x else y }

val random_number =  util.Random.nextInt

// let us use by-name parameters - that can take function or scalar values as args
def get_minmax( x: => Int, y: => Int, f: (Int, Int) => Int ): Int =
	f(x, y)

// let us test the function to find max with scalar values
val scalr_max_val = get_minmax( 5, 6 , flit_max)

// now let us pass the nextInt functions to generate ranmdom and find max
val flit_max_val = get_minmax( util.Random.nextInt, util.Random.nextInt, flit_max)

// now let us pass the nextInt functions to generate ranmdom and find MIN 
val flit_min_val = get_minmax( util.Random.nextInt, util.Random.nextInt, flit_min)

//literal function to return the y all the time
val flit_pick2nd = (x: Int, y: Int) => {println(s"x: ${x}, y: ${y} ") ;  y }

val flit_pick2_val = get_minmax( util.Random.nextInt, util.Random.nextInt, flit_pick2nd )


//5.3

// this thing looks highly complicated 
def product(x: Int): Int => Int = 
	val flit_fn = (y: Int) => x * y
	flit_fn 

val the_function = product(10)
val final_prod = the_function(10)
 

//5.4
//what does this function do?  invoke it.
def fzero[A](x: A)(f: A => Unit): A = { f(x); x }

//the above function uses a type parameter. it has two parameter groups.
// It takes in arg x.  
//Calls a procedure that does not return any value, and then returns x from itself a type A.

val fzero_val  = fzero[String]("Hello")( (x: String) => println(x * 3) )
val fzero_val2 = fzero[String]("There")(t => println(t.reverse)) // uses simpler literalfn syn.


//5:5
/* is the following correct to define a fuction value?
def square(m: Double) = m * m
val sq = square

answer: no.  the currect way to do it woudl be:
*/

def square(m: Double) = m * m
val sq = square _
sq(11)


//5.6

def conditional[A]( x: A, p: A => Boolean , f: A => A ) : A  = if ( p(x) ) f(x) else x

val flit_ispositive = (x: Int) => x > 0
val flit_gennum = (x: Int) => x*x

var cond_val = conditional[Int](3, flit_ispositive, flit_gennum)  // 9. its +ve. so square it
var cond_val_neg = conditional[Int](-3, flit_ispositive, flit_gennum) // -3. -ve. so 3.

// 5.7
def conditional_ts[A]( x: A, p: A => Boolean , f: A => String ) : String  = if ( p(x) ) f(x) else x.toString

val flit_gennum_ts = (x: Int) => { 
	val x1 = if ( x % 3 == 0 ) "Type" else "" 
	val y1 = if ( x % 5 == 0 ) "Safe" else "" 
	if (x1 + y1 == "") x.toString else x1+y1
}
flit_gennum_ts(6)
flit_gennum_ts(-6)

val cond_val_ts = conditional_ts[Int](3, flit_ispositive, flit_gennum_ts)  // 9. its +ve. so square it
val cond_val_neg_ts = conditional_ts[Int](-3, flit_ispositive, flit_gennum_ts) // -3. -ve. so 3.

for ( n <- 1 to 100)  print( conditional_ts[Int](n, flit_ispositive, flit_gennum_ts) + " ")


