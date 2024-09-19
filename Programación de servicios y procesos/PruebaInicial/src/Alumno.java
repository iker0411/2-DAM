import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String apellido;
    private int edad;
    private String curso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", curso='" + curso + '\'' +
                '}';
    }

    public static void main(String[] args) {
       List<Alumno> alumnos = new ArrayList();
       Alumno a1 = new Alumno();
       a1.setNombre("Alumno");
        System.out.println(a1);


    }
}
