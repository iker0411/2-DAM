import java.util.*


fun main(args: Array<String>) {
    feedTheFish()
    println("Argumentos de entrada al main: ")
    args.forEach {
        println("$it, ")

    }
    println("\n-----------------------------------")
    arrays()
    println("\n-----------------------------------")
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


fun arrays() {
    val school = listOf("mackerel", "trout", "halibut")

    println("Los elementos de una lista son: ")
    school.forEach {
        println("$it, ")
    }

    val myList = mutableListOf("tuna", "salmon", "shark")
    myList.add(myList.size - 1, "sardina")
    myList.add(myList.lastIndex, "boquerones")
    println(myList)
    for ((index, element) in myList.withIndex()) {
        when {
            index == myList.lastIndex - 1 -> print("y $element y ")
            index == myList.lastIndex -> print("$element, ")
            else -> print("$element. ")
        }
    }

    println(sumaEnteras(3,8))

    val temperatura = 10
    val  isHot = if (temperatura > 50 ) true else false
    println(isHot)
    val temperature = 10
    val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
    println(message)
}
 fun sumaEnteras(a : Int, b : Int) : Int{
    return a+b
 }
fun sayhello(): String {
    return "Hello World!"
}

/*fun feedTheFish() {
    val day = randomDay()
    val food =
    println ("Today is $day and the fish eat $food")
}*/
fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}
fun fishFood (day : String) : String {
    var food = ""
    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
    }
    return food
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)

    println ("Today is $day and the fish eat $food")
}
fun swim(speed: String = "fast") {
    println("swimming $speed")
}
