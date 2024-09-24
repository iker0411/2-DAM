fun main(args: Array<String>) {
    arrays()
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
    when {
        (fixed > 50) -> println("X e Y son iguales")
        (x > y) -> println("X es mayor que y")
        (x < y) -> println("X es menor que Y")
        else -> println(" X e Y son iguales")
    }
    var nombre: String? = null
//println ("hola $nombre, mi nombre tiene ${nombre?.length} letras")
    println("Dime tu nombre:")
    nombre = readlnOrNull()

    nombre?.let {
        println("hola $it, mi nombre tiene ${it.length} letras.")
    } ?: println("El nombre es nulo")
}
fun arrays(){
    val school = listOf("mackerel", "trout", "halibut")

    println("Los elementos de una lista son: ")
    school.forEach{
        println("$it, ")
    }

    val  myList = mutableListOf("tuna", "salmon", "shark")
    myList.add(myList.size -1, "sardina")
    myList.add(myList.lastIndex, "boquerones")
    println(myList)
}

fun sayhello(): String {
    return "Hello World!"
}