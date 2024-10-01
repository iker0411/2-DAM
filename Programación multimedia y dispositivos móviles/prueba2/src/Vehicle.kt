interface Vehicle {
    val vehicle : String
    fun navigate()
    fun place() {
        println("He estacionado el $vehicle.")
    }

}