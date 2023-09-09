val response: String = "xxxnull"
response match {
	case sss if sss != null => println(s"Received ${sss}")
	case sss => println(s"Error! Received a null response ${sss}")
}



val check_this = "No"
val yes = "xxx"  // this value definition has no impact on the yes pattern defined in the case statement.
// this case pattern guard condition is too confusing!!
val outcome = check_this match {
	case yes  if yes == "Yes"  => "This is YES.  I say Yes"  // the check_this value is passed into the case and assinged to yes till the experession is evaluated.
	case no if no == "No" => {val ct = f"${"No "*3}";  ct + " That's it"}
	case _ => "I don't know whats in your mind"
}

/*
val status = 500

val message = status match {
	case 200 =>
		"ok"
	case 400 => {
		println("ERROR - we called the service incorrectly")
		"error"
	}
	case 500 => {
		println("ERROR - the service encountered an error")
		"error"
	}
}
*/

// with day as MONxx the block would error out.
val day = "MONxx"
/*
val kind = day match {
	case "MON" | "TUE" | "WED" | "THU" | "FRI" =>
		"weekday"
	case "SAT" | "SUN" =>
		"weekend"
}
// this will not error out with day as MONxx because the block has wildcad
val kind2 = day match {
	case "MON" | "TUE" | "WED" | "THU" | "FRI" =>
		"weekday"
	case "SAT" | "SUN" =>
		"weekend"
	case other =>
		s"What day is: ${day * 5}"
}

// this will not error out with day as MONxx because the block has wildcad
val kind3 = day match {
	case "MON" | "TUE" | "WED" | "THU" | "FRI" =>
		"weekday"
	case "SAT" | "SUN" =>
		"weekend"
	case _ =>
		s"What day is: ${day * 5}"
}
*/

