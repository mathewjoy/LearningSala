// example of expression block
// this is a very strange thing.  this kid of block is very unuque.

val amt = { val x = 5 * 20; x + 10 }

val amt2 = {
	val y = 8*3; 
	y + amt
}

val num1 = { val a = 1; { val b = a * 2; { val c = b + 4; c } } }
