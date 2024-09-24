import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Necesitas introducir un parámetro de entrada");
            return;
        }

        String nombreFichero = args[0];

        //ejemploEscrituta1(nombreFichero);
        ejemploEscrituta2(nombreFichero);
    }

    private static void ejemploEscrituta1(String nombreFichero) {
        try (FileWriter fw = new FileWriter(nombreFichero, true)) {
            fw.write(' ');
            fw.write('H');
            fw.write('O');
            fw.write('L');
            fw.write('A');
        } catch (IOException io) {
            System.out.println("Error en la E/S. " + io.getMessage());
        }
    }

    private static void ejemploEscrituta2(String nombreFichero) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));
            bw.write("Esto es un fichero de texto.");
            bw.newLine();
            bw.write("que estamos construyendo con un flujo con buffer");
            bw.newLine();
            bw.close();
            bw = new BufferedWriter(new FileWriter(nombreFichero, true));
            bw.write("Esta cadena puede machacar el contenido");
            bw.close();
        } catch (IOException io) {
            System.out.println("Error en la E/S. " + io.getMessage());
        }
    }

}
