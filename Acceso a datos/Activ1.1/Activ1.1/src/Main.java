import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            menu();
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    BBDDFicheros.cargarInforma("C:\\Users\\ikerM\\Desktop\\Instituto\\2DAM\\Acceso a datos\\Activ1.1\\Activ1.1\\BBDDCoches.csv");
                    break;
                case 2:
                    BBDDFicheros.insertar();
                    break;
                case 3:
                    BBDDFicheros.ordenarFichero();
                    break;
                case 4:
                    BBDDFicheros.borrarRegistro();
                    break;
                case 5:
                    BBDDFicheros.modificarRegistro();
                    break;
                default:
                    System.out.println("Gracias por utilizar este programa, ads :)");
                    break;
            }
        } while (opcion != 6);
        // Cierra el objeto Scanner.
        sc.close();
        // Cierra el escáner de la clase BBDDFicheros.
        BBDDFicheros.cerrarEscaner();
    }

    public static void menu() {
        System.out.println("==========Menú=============");
        System.out.println("1.Cargar información");
        System.out.println("2.Insertar un coche");
        System.out.println("3.Ordenar por matrícula");
        System.out.println("4.Borrar un registro");
        System.out.println("5.Modificar un registro");
        System.out.println("6.Salir");
        System.out.println("Eliga una opción:");
    }
}
