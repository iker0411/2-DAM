class Car(brand: String) {
    //Al declararlo en el cuerpo de la clase, en su constructor no
    // se declara de forma interna siendo un argumento que habría que
    //asignar a este val interno, aunque sí llamarse por lo que no lleva
    // "val"
    val brand: String
    var model: String = ""
    var year: Int? = null

    //bloque de inicialización. Se puede eliminar por la
    // inicialización en la propia declaración.
    init {
        this.brand = brand
    }

    //constructor secundario.
    constructor(brand: String, model: String, year: Int?) :
            this(brand) {
        this.model = model
        this.year = year
    }
}
