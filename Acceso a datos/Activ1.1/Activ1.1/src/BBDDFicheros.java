import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class BBDDFicheros {
    private static final String nombreF = "prueba.dat";
    public static void cargarInforma() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("BBDD Coches.csv"));
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] posi = linea.split(",");
                String matricula = posi[0];
                String marca = posi[1];
                String modelo = posi[2];
                Coche coche = new Coche(matricula, marca, modelo);
                guardarInformacion(coche);
            }
            br.close();
            System.out.println("Se ha guardado correctamente la información");
        } catch (IOException e) {
            System.out.println("Error E/S: " + e.getMessage());
        }
    }

    public static void guardarInformacion() {

        try(FileOutputStream fos = new FileOutputStream(nombreF, true)) {
            for (Coche coche : coches){
                fos.write(coche.toString().);
            }

        } catch (IOException e) {
            System.out.println("Error E/S: " + e.getMessage());
        }
    }
}
