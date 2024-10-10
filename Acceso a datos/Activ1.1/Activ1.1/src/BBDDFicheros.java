import java.io.*;
import java.util.*;

public class BBDDFicheros {
    static Scanner sc = new Scanner(System.in);
    private static final String nombreF = "Coche.dat";


    /**
     * Este método lee un archivo de texto línea por línea, omitiendo la primera línea (cabecera),
     * y crea objetos de tipo Coche con los datos leídos. Los objetos creados se añaden a una lista,
     * que posteriormente se guarda mediante el método  guardarInformacion.
     * <p>
     * Resumen: Carga la información de coches desde un archivo y la guarda en una lista.
     */
    public static void cargarInforma(String nombreF) {
        File fichero1 = new File(nombreF);
        List<Coche> coches = new ArrayList<>();
        // Intentar abrir el archivo y leer su contenido
        try (BufferedReader br = new BufferedReader(new FileReader(fichero1))) {
            String linea;
            // Leer la primera línea (cabecera) y descartarla
            br.readLine();
            // Leer el resto de las líneas del archivo
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes usando la coma como separador
                String[] posi = linea.split(",");
                String matricula = posi[0];
                String marca = posi[1];
                String modelo = posi[2];
                // Crear un nuevo objeto Coche con los datos leídos
                Coche coche = new Coche(matricula, marca, modelo);
                // Añadir el objeto Coche a la lista
                coches.add(coche);
            }
            // Guardar la información de la lista de coches
            guardarInformacion(coches);
            // Cerrar el BufferedReader
            br.close();
            System.out.println("Se ha cargado correctamente la información");
        } catch (FileNotFoundException e) {
            // Manejar la excepción en caso de que el archivo no se encuentre
            System.out.println("Error E/S: " + e.getMessage());
        } catch (IOException e) {
            // Manejar la excepción en caso de un error de entrada/salida
            System.out.println("Error E/S: " + e.getMessage());
        }
    }

    /**
     * Este método recibe una lista de objetos  Coche y guarda su información en un archivo llamado coche.dat.
     * Para ello, crea un objeto  BufferedWriter para escribir en el archivo. Recorre la lista
     * de coches y escribe los datos de cada coche en el archivo, rellenando los campos según el tamaño
     * especificado y haciendo un salto de línea después de cada coche.
     * <p>
     * Resumen: Guarda la información de una lista de coches en un archivo llamado Coche.dat.
     */
    public static void guardarInformacion(List<Coche> coches) {
        // Intentar abrir el archivo para escribir usando BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreF))) {
            // Recorrer la lista de coches
            for (Coche coche : coches) {
                // Escribir la matrícula del coche, rellenando hasta 7 caracteres.
                //Los demás son iguales.
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

    /**
     * Este método lee los datos de un archivo llamado Coche.dat, pide al usuario que ingrese la posición
     * donde desea insertar un nuevo coche, solicita los datos del coche, crea un objeto
     * Coche con los datos proporcionados y lo inserta en la posición indicada.
     * Finalmente, guarda la lista actualizada de coches en el archivo.
     * <p>
     * Resumen: Inserta un nuevo coche en una posición específica de la lista de coches
     */
    public static void insertar() {
        // Crear la lista de coches que se llenará con los datos del archivo
        List<Coche> coches = recorrer("Coche.dat");

        // Pedir al usuario que ingrese la posición

        int po = leerEntero("Ingrese la posición para insertar el coche");

        // Verificar si la posición es válida
        if (po >= 0 && po <= coches.size()) {
            // Pedir los datos del coche

            String matricula = leerCadena("Introduce la matrícula del coche");
            String marca = leerCadena("Introduce la marca del coche");

            String modelo = leerCadena("Introduce el modelo del coche");

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

    /**
     * Este método lee los datos de un archivo Coche.dat, ordena la lista de coches por la matrícula
     * utilizando el método  Collections.sort y guarda la lista ordenada en el archivo.
     * <p>
     * Resumen: Ordena la lista de coches por la matrícula y guarda la lista ordenada en un archivo.
     **/
    public static void ordenarFichero() {
        // Leer los datos del archivo CSV y llenar la lista de coches
        List<Coche> coches = recorrer("Coche.dat");
        // Ordenar la lista de coches por la matrícula
        Collections.sort(coches, (a, b) -> a.compareTo(b));
        // Guardar la lista ordenada de coches en el archiv
        guardarInformacion(coches);
        System.out.println("El fichero ha sido ordenado correctamente por la matricula");
    }

    /**
     * Este método solicita al usuario que elija si desea borrar un registro de coche
     * por matrícula o por posición. Luego, llama al método correspondiente para realizar
     * la eliminación.
     * <p>
     * Resumen: Borra un registro de coche basado en la matrícula o la posición.
     **/
    public static void borrarRegistro() {
        // Solicitar al usuario que elija el criterio de borrado
        System.out.println("¿Cual registro quieres borrar?");
        System.out.println("1.Matricula");
        System.out.println("2.Posición");
        int in = sc.nextInt();
        // Consumir la nueva línea
        sc.nextLine();
        // Verificar la opción seleccionada por el usuario
        if (in == 1) {
            // Solicitar la matrícula del coche a borrar
            String matricula = leerCadena("Introduce la matricula del coche, que quieras borrar ");
            // Llamar al método para borrar el coche por matrícula
            borrarRegistroMatricula(matricula);
        } else if (in == 2) {
            int pos = leerEntero("Introduce la posicion que quieras borrar ");
            borrarRegistroPosicion(pos);
        } else {
            System.out.println("Opción invalida, selecciona el 1 o el 2");
        }
    }

    /**
     * Este método lee los datos del archivo Coche.dat, solicita al usuario que ingrese la posición
     * del coche que desea modificar, permite al usuario actualizar la marca y el modelo del coche,
     * y guarda la lista actualizada de coches en el archivo.
     * <p>
     * Resumen: Modifica un registro de coche en una posición específica de la lista de coches.
     **/
    public static void modificarRegistro() {
        Scanner sc = new Scanner(System.in);
        // Leer los datos del archivo CSV y llenar la lista de coches
        List<Coche> coches = recorrer("Coche.dat");

        // Solicitar al usuario que ingrese la posición del coche a modificar
        int posicion = leerEntero("Introduce la posición del coche a modificar ");
        // Verificar si la posición es válida
        if (posicion >= 0 && posicion < coches.size()) {
            // Obtener el coche en la posición especificada
            Coche coche = coches.get(posicion);
            // Solicitar al usuario que ingrese la nueva marca del coche
            System.out.print("Introduce la nueva marca (actual: " + coche.getMarca() + ") ");
            // Actualizar la marca del coche con el valor ingresado por el usuario
            coche.setMarca(sc.next());
            System.out.print("Introduce el nuevo modelo (actual: " + coche.getModelo() + ") ");
            coche.setModelo(sc.next());
            // Guardar la lista actualizada de coches en el archivo
            guardarInformacion(coches);
            System.out.println("Coche modificado correctamente.");
        } else {
            System.out.println("Modificación inválida.");
        }

    }

    //Metodos Auxiliares

    /**
     * Este método lee los datos del archivo Coche.dat, busca el coche con la matrícula especificada
     * y lo elimina de la lista. Si el coche es encontrado y eliminado, la lista actualizada
     * se guarda de nuevo en el archivo. Si no se encuentra ningún coche con la matrícula
     * proporcionada, se muestra un mensaje indicándolo.
     * <p>
     * Resumen: Elimina un registro de coche basado en su matrícula.
     **/
    public static void borrarRegistroMatricula(String matricula) {
        // Leer los datos del archivo CSV y llenar la lista de coches
        List<Coche> coches = recorrer("Coche.dat");
        // Intentar eliminar el coche con la matrícula especificada
        boolean eliminado = coches.removeIf(coche -> coche.getMatricula().equals(matricula));
        if (eliminado) {
            // Guardar la lista actualizada de coches en el archivo
            guardarInformacion(coches);
            System.out.println("El coche con matricula " + matricula + " ha sido eliminado.");
        } else {
            System.out.println("No se encontró ningún coche con matricula: " + matricula);
        }
    }

    /**
     * Este método lee los datos del archivo Coche.dat, verifica si la posición especificada es válida,
     * y elimina el coche en esa posición de la lista. Si el coche es encontrado y eliminado,
     * la lista actualizada se guarda de nuevo en el archivo. Si la posición es inválida,
     * se muestra un mensaje indicándolo.
     * <p>
     * Resumen: Elimina un registro de coche basado en su posición en la lista.
     **/
    public static void borrarRegistroPosicion(int posicion) {
        List<Coche> coches = recorrer("Coche.dat");
        if (posicion >= 0 && posicion < coches.size()) {
            Coche cocheEliminado = coches.remove(posicion);
            guardarInformacion(coches);
            System.out.println("Coche en posicion " + posicion + " (matricula: " + cocheEliminado.getMatricula() + ") ha sido eliminado.");
        } else {
            System.out.println("Posicion invalida. No se ha podido eliminar el coche");
        }
    }

    /**
     * Este método muestra un mensaje al usuario, lee una línea de entrada desde la consola
     * <p>
     * Resumen: Lee un número entero desde la entrada estándar.
     **/
    public static int leerEntero(String mensaje) {
        // Muestra el mensaje al usuario indicando que debe ingresar un número entero.
        System.out.println(mensaje + ": ");
        // Lee una línea de texto de la entrada estándar y la convierte a un número entero.
        // Se utiliza Integer.parseInt para realizar la conversión.
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * Este método libera los recursos asociados con el objeto Scanner.
     * Es importante cerrar el Scanner cuando ya no se necesite para evitar
     * fugas de recursos. Sin embargo, una vez cerrado, el Scanner no debe ser
     * reutilizado.
     * Resumen: Cierra el objeto Scanner utilizado para la entrada estándar.
     **/
    public static void cerrarEscaner() {
        // Cierra el objeto Scanner, liberando los recursos que estén asociados.
        sc.close();
    }

    /**
     * Este método solicita al usuario que ingrese una cadena de texto, asegurándose
     * de que no esté vacía. Muestra el mensaje proporcionado como parámetro y sigue
     * solicitando la entrada hasta que el usuario ingrese un valor válido (no vacío).
     * <p>
     * Resumen: Muestra un mensaje al usuario y lee una cadena de texto desde la entrada estándar.
     **/
    public static String leerCadena(String mensaje) {
        // Muestra el mensaje al usuario indicando que debe ingresar una cadena de texto.
        System.out.println(mensaje + ":");

        String cadena = null;
        // Sigue pidiendo al usuario que ingrese una cadena hasta que no esté vacía.
        do {
            cadena = sc.nextLine(); // Lee la cadena de texto desde la entrada estándar.
        } while (cadena.isEmpty()); // Repite si la cadena está vacía.

        // Retorna la cadena de texto ingresada por el usuario.
        return cadena;
    }

    /**
     * Este método utiliza la función String.format para rellenar la cadena
     * proporcionada con espacios en blanco a la derecha, hasta que la longitud de la cadena
     * sea igual al tamaño especificado.
     * <p>
     * Resumen: Rellena una cadena con espacios hasta alcanzar un tamaño especificado.
     ***/
    public static String rellenar(String datos, int size) {
        return String.format("%-" + size + "s", datos);
    }

    /**
     * Este método abre el archivo especificado, lee cada línea y extrae los datos
     * de cada coche (matrícula, marca y modelo) para crear una lista de objetos Coche.
     * Si el archivo no se encuentra o hay un error al leerlo, se muestra un mensaje
     * de error correspondiente.
     * <p>
     * Resumen: Lee un archivo y devuelve una lista de objetos Coche.
     **/
    public static List<Coche> recorrer(String nombreF) {
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