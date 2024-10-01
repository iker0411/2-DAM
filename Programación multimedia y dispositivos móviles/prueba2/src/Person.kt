open class Person  (protected var name : String, protected var age : Int){
    open fun introducePerson() {
        println("Hola, mi nombre es $name y mi edad es $age")
    }
}