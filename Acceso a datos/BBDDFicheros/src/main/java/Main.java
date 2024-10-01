import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

            Map<String, Integer> campos = new HashMap<String, Integer>();
            campos.put("Matricula", 7);
            campos.put("Marca", 32);
            campos.put("Modelo", 32);
        try {
            BBDDFicheros bbddFicheros = new BBDDFicheros("Coche.dat", campos, "Matricula");
            HashMap<String, String> coches = new HashMap<String, String>();
            coches.put("Matricula", "1111AAA");
            coches.put("Marca", "Seat");
            coches.put("Modelo", "Leon");
            bbddFicheros.insertar(coches);
            coches.clear();
            coches.put("Matricula", "2222BBB");
            coches.put("Marca", "Toyota");
            coches.put("Modelo", "CH-R");
            bbddFicheros.insertar(coches);
            coches.clear();
            coches.put("Matricula", "3333CCC");
            coches.put("Marca", "Kia");
            coches.put("Modelo", "Sportage");
            bbddFicheros.insertar(coches);
            coches.clear();
            coches.put("Matricula", "4444DDD");
            coches.put("Marca", "Ferrari");
            coches.put("Modelo", "Enzo");
            bbddFicheros.insertar(coches);
            coches.clear();
            coches = (HashMap<String, String>) bbddFicheros.recuperar("2222BBB");
            for (Map.Entry<String, String> coche : coches.entrySet()) {
                System.out.println(coche.getKey() + " : " + coche.getValue());
            }
        } catch (IOException IO) {
            System.out.println("Exception E/S: " + IO.getMessage());
        }
    }
}
