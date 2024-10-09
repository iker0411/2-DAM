import java.io.*;
import java.util.List;
public class BBDDFicheros {
    private static final String nombreF = "Coche.dat";
    public static void cargarInforma(List<Coche> coches) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("BBDDCoches.csv"));
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] posi = linea.split(",");
                String matricula = posi[0];
                String marca = posi[1];
                String modelo = posi[2];
                Coche coche = new Coche(matricula, marca, modelo);
               coches.add(coche);
            }
            guardarInformacion(coches);
            br.close();
            System.out.println("Se ha cargado correctamente la información");
        } catch (IOException e) {
            System.out.println("Error E/S: " + e.getMessage());
        }
    }

    public static void guardarInformacion(List<Coche> coches) {

        try {
           BufferedWriter bw = new BufferedWriter(new FileWriter(nombreF));
            for (Coche coche : coches){

            }

        } catch (IOException e) {
            System.out.println("Error E/S: " + e.getMessage());
        }
    }


    public static void insetar()
    public static void rellenar(String dato, int size){
        String rel = String.format("%-" + dato + "s", size);
    }
}
