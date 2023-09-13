//4.1 are of a circle

def area(r : Double) : Double = {val pi=3.14; pi * r * r}

//val area = area(5) // see varible is same as fn name and it FAILS!
val a = area(5) // see varible is same as fn name and it FAILS!

println(a)

//4.2 are of a circle

def area2(r : String) : Double = {val pi=3.14; pi * r.toDouble * r.toDouble}
val a2 = area2("5") // see varible is same as fn name and it FAILS!
println(a2)

//the following has questionable results; it gives "empty string" error
//val a3 = area2("") // see varible is same as fn name and it FAILS!
//println(a3)


//4.3 recursive with tail recursive annotation for heap optimization

//prints decending
@annotation.tailrec
def printinfive(i : Int ): Int = {
	if ( i >= 5 ) {
		println (i)
		printinfive( i - 5) // remember: the function returns Int.
	}
	else 
		println (i)
		1 // return this.  you must have an Int return
}

printinfive(50)

//print ascending
@annotation.tailrec
def printinfive2(i : Int ): Int = {
	if ( i < 50 ) {
		println (i)
		printinfive2( i + 5) // remember: the function returns Int.
	}
	else 
		println (i)
		1 // return this.  you must have an Int return
}

printinfive2(6)


//4.4

def milliSecToStr(m :Long ) = {
	val ms = m % 1000 		//millisecs left over
	val totsec = m / 1000		//seconds

	val sec = totsec % 60 		//seconds left over
	val totmin = totsec / 60

	val min  = totmin % 60		//hrs left over 
	val tothr = totmin / 60

	val hr = tothr % 24
	val dy = tothr / 24

	s"${dy} d ${hr} h ${min} m ${sec}.${ms} s"
}

val tstr1 = milliSecToStr(1400)  	//1.4 sec
val tstr2 = milliSecToStr(3600000)  	
val tstr3 = milliSecToStr(36000000)  	
val tstr4 = milliSecToStr(360000000)  	
val tstr5 = milliSecToStr(26*60*60*1000)  	//26 hrs


//4.5
math.pow(2,3)

def mypow(x: Double, y: Int) : Double = {

	var prd: Double = 1

	for ( i <- 1 to y  )  prd *= x
	prd
}

mypow(2.5, 3)
mypow(3.0, 3)



def mypow2(x: Double, y: Int) : Double = {
	if ( y > 1 ) x  * mypow(x,  y - 1)
	else 1
}

mypow2(2.5, 3)
mypow2(3.0, 3)

// tail recursion with optimizatio to prevent heap allocation errors
@annotation.tailrec
def mypow4(x: Double, y: Int, prd :Double = 1) : Double = {
	if ( y <= 1 ) prd*x
	else mypow4(x,  y - 1, prd*x)
}

mypow4(2.5, 3)
mypow4(3.0, 3)


//4.6

// don't use the Tuple type, but just create a tuple of integer (Int, Int).
// The data type Tuple is more difficult to handl
// def pointdiff( p1: Tuple, p2: Tuple) : Tuple = { // tough to make it work

def pointdiff( p1: (Int, Int), p2: (Int, Int) ) : (Int, Int) = {
	(p2._1 - p1._1, p2._2 - p1._2)
}

def pointdiffxx( x1: Int, y1: Int, x2: Int, y2: Int): Tuple = {
	val pnt1 = (5,2)
	val (bx, by) = (pnt1._1, pnt1._2)
	(x2-x1, y2-y1)
}


val pnt1 = (5,2)
val pnt2 = (4,1)
println(pnt1._1)
val (ax, ay) = (pnt1._1, pnt1._2)
pointdiff( pnt1, pnt2 )
pointdiffxx( 5,2 , 4, 1 )


//4.7

def intFirst[A, B](x: (A, B)) : (Any, Any) = {
	def isInt(x : Any) = x.isInstanceOf[Int] 
	
	(isInt(x._1), isInt(x._2) ) match {
		case ( false, true ) => (x._2, x._1) //make the int first
		case other => x // no change. return as is.
	}
}

intFirst[String, Int](("Hello", 1))
intFirst((1, 2))
intFirst(("Yea", "abc"))
intFirst((2, "abc"))


//4.8
def myStr[A, B, C](x: (A, B, C)) : (A, String, B, String, C, String) = {
	( x._1, x._1.toString, x._2, x._2.toString, x._3, x._3.toString )	
}

val ret : (String, String, Double, String, Boolean, String) =  myStr("ABC", 3.3443, false)


