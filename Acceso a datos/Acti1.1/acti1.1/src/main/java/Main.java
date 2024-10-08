import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pulsa 1 para carga la informacion:");
        System.out.println("Pulsa 2 para insetar un coche:");
        System.out.println("Pulsa 3 para ordenar fichero");
        System.out.println("Pulsa 4 para borrar un registro:");
        System.out.println("Pulsa 5 para modificar un registro:");
        int opcion = sc.nextInt();
        if (opcion == 1) {

        } else if (opcion == 2) {

        } else if (opcion == 3) {

        } else if (opcion == 4) {

        } else if (opcion == 5) {

        } else {
            System.out.println("Gracias por utilizar este programa :)");
            System.exit(1);
        }

    }
}
