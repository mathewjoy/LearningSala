// basic loop syntax: for (<identifier> <- <iterator>) [yield] [<expression>]
println(" basic loop one")
for (x <- 1 to 7) { 
	println(s"Day $x:") 
}

val range = 1 to 8

println("basic loop 2")
for (x <- range ) { 
	println(s"Day $x:") 
}

// can it return expression???

println("basic loop 3  with a return")  // not working.
val abc = for (x <- range ) { 
	s"Day $x:"  // return expression
}
println(s"abc is: ${abc}")

println("basic loop 4 with a yield")
// and now with yield - returning vector

val output = for (x <- range) yield { s"Day $x:" }
println(":yielded " + output.toString + ":")


