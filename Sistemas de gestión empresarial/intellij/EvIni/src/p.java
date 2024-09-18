import java.util.Scanner;

public class p {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numEnt;
        System.out.println("Dime el número que hay de cocodrilos");
        do {
            numEnt = Integer.parseInt(sc.next());
            if (numEnt < 1 || numEnt > 50){
                System.out.println("No puede ser inferior a 1 ni susperior a 50");
            }
        }while (numEnt < 1 || numEnt > 50);
        System.out.println("e");

    }
}
