import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numEnt;
        String nombre;
        int cocodriloLlorando = 0;

        String[] vocales = {"a", "e", "i", "o", "u"};
        System.out.println("Dime el número que hay de cocodrilos:");
        do {
            numEnt = Integer.parseInt(sc.nextLine());
            if (numEnt < 1 || numEnt > 50) {
                System.out.println("No puede ser inferior a 1 ni superior a 50");
            }
        } while (numEnt < 1 || numEnt > 50);
        for (int i = 0; i < numEnt; i++) {
            System.out.println("Dime el nombre del cocodrilo: ");
            nombre = sc.nextLine().toLowerCase();
            if (nombre.length() > 10) {
                System.out.println("No puede ser superior a 10 letras");
            }
        }

    }
}
