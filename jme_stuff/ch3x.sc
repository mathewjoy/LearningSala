// 3.1 val name = null 

val eval = 
	name match {
	case nm if nm != null => name
	case other => "n/a"
	} 


// 3.2

val d: Double = -100.0

val output = if ( d > 0.0 ) "greater"
	else if ( d == 0.0 ) "same"
     		else "less"


val output2 = 
	d match {
		case g if g > 0.0 => "greater"
		case e if e == 0.0 => "same"
		case l if l < 0.0 => "less"
	}


//3.3

val color_in = "cyancc"

val color_hex = 
	color_in match {
		case "cyan" => "0x00FFFF"
		case "magenta" => "0x00FFA"
		case "yellow" => "0x00FFB"
		case other => "Unknown"
	}

//3.4

for {
	i <- 1 to 100/5
	j <- 1 to 5 
}
{
if ( j == 1) println("")
print( s"${5*(i-1)+j} ")
}
println("")


//3.5

for {
	i <- 1 to 100/5
	j <- 1 to 5 
}
{
if ( j == 1) println("")
val print_val = 
	if ( (5*(i-1)+j) % 3 == 0  & (5*(i-1)+j) % 5  == 0) "typesafe" 
	else if ((5*(i-1)+j) % 3 == 0 )  "type" 
		else if ((5*(i-1)+j) % 5 == 0 )  "safe" 
			else 5*(i-1)+j
print( s"${print_val} ")
}
println("")


//3.6 - rewriting the above into one line:

for (i <- 1 to 100) {var tmp ="";if (i%3 == 0) tmp="type"; if (i%5 == 0)  tmp+="safe"; if (tmp =="") tmp=i.toString; print(s"${tmp} ")}

