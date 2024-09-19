fun main(args: Array<String>) {
    var x = 2
    val fixed: Float = 5f
    x = x.times(40)
//    val y = fixed.plus(10) + 5 * 4
    val y = 80
    println("hola mundo, x=$x y=$y")
    println(sayhello());
    if (x > y) {
        println("x es mayor que y")
    } else if (x == y.toInt()) {
        println("x e y son iguales")
    } else {
        println("y es mayor que x")
    }
}

fun sayhello(): String {
    return "Hello World!"
}