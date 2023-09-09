// guard or also known as filter with in-line filter
val threes = for (i <- 1 to 20 if i % 3 == 0) yield i

//offline filter

val quote = "Faith,Hope,,,Charity"
for {
	t <- quote.split(",")
	if t != null
	if t.size > 0
}
{ println(t + " " + t.size) }

// nested loop:

for { 
	x <- 1 to 2
	y <- 1 to 3 
}
{ print(s"($x,$y) ") }
println("")

//

for { 
	x <- 1 to 2
	y <- 1 to x 
}
{ print(s"($x,$y) ") }
println("")


// looping with value binding: see pow
val powersOf2 = for (i <- 0 to 8; pow = 1 << i) yield pow

