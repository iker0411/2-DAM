import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========Menú=============");
        System.out.println("1.Cargar información");
        System.out.println("2.Insertar un coche");
        System.out.println("3.Ordenar por matrícula");
        System.out.println("4.Borrar un registro");
        System.out.println("5.Modificar un registro");
        System.out.println("Eliga una opción:");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if (opcion == 1) {
            BBDDFicheros.cargarInforma();
        } else {
            System.out.println("Gracia por utiliza este programa");
        }
    }
}
