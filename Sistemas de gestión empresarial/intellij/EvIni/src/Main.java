import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numEnt;
        System.out.println("Dime el número que hay de cocodrilos:");
        do {
            numEnt = Integer.parseInt(sc.nextLine().toLowerCase());
            if (numEnt < 1 || numEnt > 50) {
                System.out.println("No puede ser inferior a 1 ni superior a 50");
            }
        } while (numEnt < 1 || numEnt > 50);
pp
    }
}
