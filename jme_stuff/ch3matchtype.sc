val x: Int = 12180
val y: Any = x

y match {
case x: String => s"'x'"
case x: Double => f"$x%.2f"
case x: Float => f"$x%.2f"
case x: Long => f"${x}l"
case x: Int => f"${x}i"
}

val y2: Any = x.toString
y2 match {
case xxx :String => s"'xxx'"
case x: Double => f"$x%.2f"
case x: Float => f"$x%.2f"
case x: Long => f"${x}l"
case x: Int => f"${x}i"
}

