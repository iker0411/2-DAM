public class Coche implements Comparable<Coche>{


    private String matricula;
    private String marca;
    private String modelo;

    public Coche(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *Este método sobrescribe el método toString de la clase Object para proporcionar
     *una representación legible de la instancia de Coche, mostrando la matrícula,
     *la marca y el modelo del coche separados por espacios.
     *<p>
     *Resumen: Devuelve una representación en forma de cadena del objeto Coche.
     * **/
    @Override
    public String toString() {
        // Devuelve la matrícula, la marca y el modelo del coche como una cadena.
        return  matricula + " " + marca + " " + modelo;
    }

    @Override
    public int compareTo(Coche o) {
        // Compara la matrícula de este coche con la matrícula del coche dado.
        return this.matricula.compareTo(o.matricula);
    }
}
