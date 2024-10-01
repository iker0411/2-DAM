class Programer (nombre: String, edad: Int, private val language : ProgrammingLang) : Person(nombre, edad){
    private var programsCreated : MutableList<String> =
        mutableListOf()
    override fun introducePerson() {
        super.introducePerson()
        println("Además, soy programador especialista en $language")
    }
    fun createProgram(program : String) {
        programsCreated.add(program)
    }
    fun showPrograms() {
        if(programsCreated.size==0) {
            println("Todavía no he creado ningún programa.")
        } else {
            println("Ya he creado ${programsCreated.size} programas. Estos programas son:")
                    programsCreated.forEach {
                println(it)
            }
        }
    }
}
enum class ProgrammingLang {
    JAVA,
    CPP,
    KOTLIN,
    PYTHON

}