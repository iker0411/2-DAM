class Designer (name: String, age : Int) : Person(name,age) {
    override fun introducePerson() {
        super.introducePerson()
        println("Soy muy original, mi nombre es $name y soy diseñador.")
    }
}