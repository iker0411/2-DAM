import java.io.*;
import java.util.*;

public class BBDDFicheros {
    static Scanner sc = new Scanner(System.in);
    private static final String nombreF = "Coche.dat";

    public static void cargarInforma(String nombreF) {
        File fichero1 = new File(nombreF);
        List<Coche> coches = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero1));
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
        } catch (FileNotFoundException e) {
            System.out.println("Error E/S: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error E/S: " + e.getMessage());
        }
    }

    public static void guardarInformacion(List<Coche> coches) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreF))) {
            for (Coche coche : coches) {
                bw.write(rellenar(coche.getMatricula(), 7));
                bw.write(rellenar(coche.getMarca(), 32));
                bw.write(rellenar(coche.getModelo(), 32));
                //Hace un salto de linea.
                bw.newLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error E/S: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error E/S: " + e.getMessage());
        }
    }
/*
*
*
*
* */
    public static void insertar() {
        // Crear la lista de coches que se llenará con los datos del archivo
        List<Coche> coches = recorrerCSV("Coche.dat");

        // Pedir al usuario que ingrese la posición

        int po = leerEntero("Ingrese la posición para insertar el coche:");

        // Verificar si la posición es válida
        if (po >= 0 && po <= coches.size()) {
            // Pedir los datos del coche

            String matricula = leerCadena("Introduce la matrícula del coche:");
               String marca = leerCadena("Introduce la marca del coche:");

            String modelo = leerCadena("Introduce el modelo del coche:");

            // Crear un nuevo objeto Coche
            Coche nuevoCoche = new Coche(matricula, marca, modelo);

            // Insertar el nuevo coche en la posición indicada
            coches.add(po, nuevoCoche);

            // Guardar la lista actualizada de coches en el archivo
            guardarInformacion(coches);

            System.out.println("El coche ha sido insertado correctamente en la posición " + po);
        } else {
            System.out.println("La posición ingresada no es válida.");
        }
    }


   public static void ordenarFichero(){
        List<Coche> coches = recorrerCSV("Coche.dat");
       Collections.sort(coches, (a, b) -> a.compareTo(b));
       guardarInformacion(coches);
       System.out.println("El fichero ha sido ordenado correctamente por la matricula");
   }

   public static void borrarRegistro(){
       System.out.println("¿Cual registro quieres borrar?");
       System.out.println("1.Matricula");
       System.out.println("2.Posición");
       int in = sc.nextInt();
       if (in == 1){
            String matricula = leerCadena("Introduce la matricula del coche, que quieras borrar ");

       }else if (in == 2){
           int pos = leerEntero("Introduce la posicion que quieras borrar ");
       }else {
           System.out.println("Opción invalida, selecciona el 1 o el 2");
       }
   }



    //Metodos Auxiliares
   public static void borrarRegistroMatricula(){
        List<Coche> coches = recorrerCSV("Coche.dat");

   }

    public static int leerEntero(String mensaje) {
        System.out.println(mensaje + ": ");
        return Integer.parseInt(sc.nextLine());
    }

    public static String leerCadena(String mensaje) {
        System.out.println(mensaje + ":");
        String cadena = null;

        do {
            cadena = sc.nextLine();
        } while (cadena.isEmpty());

        return cadena;
    }

    public static String rellenar(String datos, int size) {
        return String.format("%-" + size + "s", datos);
    }

    public static List<Coche> recorrerCSV(String nombreF) {
        File fichero1 = new File(nombreF);
        List<Coche> coches = new ArrayList<>();
        // Leer el archivo y cargar los coches en la lista
        try (BufferedReader br = new BufferedReader(new FileReader(fichero1))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.length() >= 71) {
                    // Extraer los datos del coche de la línea leída
                    String matricula = linea.substring(0, 7).trim();
                    String marca = linea.substring(7, 39).trim();
                    String modelo = linea.substring(39).trim();
                    coches.add(new Coche(matricula, marca, modelo));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return coches;
    }
}
