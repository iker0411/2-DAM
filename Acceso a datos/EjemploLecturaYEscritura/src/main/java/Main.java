import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Necesitas introducir un parámetro de entrada");
            return;
        }

        String nombreFichero = args[0];

        //ejemploLectura4(nombreFichero);

        //ejemploEscrituta2(nombreFichero);

        ejemploEscrituta2(nombreFichero);
        String ficheroVolcado = (new File(nombreFichero).getName()) + ".dum.txt";
        try {
            volvar(new PrintStream(ficheroVolcado), nombreFichero);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

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

    private static void ejemploEscrituta3(String nombreFichero) {
        try {
            FileReader fr = new FileReader(nombreFichero);
            int caract = fr.read();
            while (caract != -1) {//Ha llegado al final del fichero
                System.out.print((char) caract);
                caract = fr.read();
            }
            fr.close();
            //fr.read();//Para probar la Excepción IOException
        } catch (FileNotFoundException fnf) {
            System.out.println(" No existe el fichero: " +
                    nombreFichero);
        } catch (IOException io) {
            System.out.println("Error en la E/S: " + io.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void ejemploLectura4(String nombreFichero) {
        try {
            BufferedReader fbr = new BufferedReader(new
                    FileReader(nombreFichero));
            int i = 0;
            String linea = fbr.readLine();
            while (linea != null) {
                System.out.format("[%d] %s", ++i, linea);
                System.out.println();
                linea = fbr.readLine();
            }
            fbr.close();
        } catch (FileNotFoundException fnf) {
            System.out.println(" No existe el fichero: " +
                    nombreFichero);
        } catch (IOException io) {
            System.out.println("Error en la E/S: " + io.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void volvar(PrintStream ps, String nombreFichero) {
        try (FileInputStream fis = new FileInputStream(new File(nombreFichero))) {
            byte[] buffer = new byte[32];
            int bytesLeidos;
            int offset = 0;
            do {
                bytesLeidos = fis.read(buffer);
                ps.format("[%5d]", offset);
                for (int i = 0; i < bytesLeidos; i++) {
                    ps.format(" %2x", buffer[i]);
                }
                offset += bytesLeidos;
                ps.println();
            } while (bytesLeidos == 32 && offset < 2048);
        } catch (IOException io) {
            System.out.println("Error en la E/S: " + io.getMessage());
        }
    }

}
