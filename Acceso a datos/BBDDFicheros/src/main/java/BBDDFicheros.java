import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class BBDDFicheros {
    private final  String nombreFich;

    private final Map<String, Integer> campos;

    private final String campoClave;

    //Longitud del registro
    public int longReg;
    //Numero del registro
    private long numReg;

    private long numRegMarcadosBorrado;

    public BBDDFicheros(String nombreFich, Map<String, Integer> campos, String campoClave) {
        this.nombreFich = nombreFich;
        this.campos = campos;
        this.campoClave = campoClave;
        this.numReg = 0;
        this.numRegMarcadosBorrado = 0;
        this.longReg = 0;

        //Calculo la longitud del fichero sumando la longitud en bytes de cada uno de ellos
        for (Map.Entry<String, Integer> campo: campos.entrySet()){
            this.longReg += campo.getValue();
        }

        File f = new File(nombreFich);
        //Si el fichero ya existe, calculo el numero de registros que tiene partiendo de la longitud de cada uno de ellos
        if (f.exists()){
            this.numReg = f.length() / longReg;
        }else {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public String getNombreFich() {

        return nombreFich;
    }

    public long getNumRegMarcadosBorrado() {
        return numRegMarcadosBorrado;
    }

    public long getNumReg() {
        return numReg;
    }

    public String getCampoClave() {
        return campoClave;
    }

    public Map<String, Integer> getCampos() {
        return campos;
    }

    public int getLongReg() {
        return longReg;
    }
    public Map<String, String> recuperar(String valorClave) {
        int pos = 0;
        boolean encontrado = false;
        Map<String, String> result = null; //he puesto = null, para corregir el error que había
        try(FileInputStream fis = new FileInputStream(this.nombreFich)){
            //recorremos todos los registros mientras no hayamos encontrado una ocurrencia del valorClave
            while (pos < this.numReg && !encontrado){
                byte[] buffer = new byte[this.longReg];
                if (fis.read(buffer,0,this.longReg) < this.longReg){
                    return null;
                }
                int offsetcampo = 0;
                String unValorClave = null;
                for (Map.Entry<String,Integer> campo: campos.entrySet()){
                    String unCampo = campo.getKey();
                    int longCampo = campo.getValue();
                    if (unCampo.equals(this.campoClave)){
                        unValorClave = new String(buffer,offsetcampo,longCampo, StandardCharsets.UTF_8);
                        break;
                    }
                    offsetcampo += longCampo;
                }
                if (valorClave.equals(unValorClave)){//Para cada registro, comparamos si unValorClave recuperado del
                    encontrado = true;
                    offsetcampo = 0;
                    result = new HashMap<String, String>();
                    for (Map.Entry<String,Integer> campo: campos.entrySet()){
                        String unCampo = campo.getKey();
                        int longCampo = campo.getValue();
                        String valorCampo = new String(buffer,offsetcampo,longCampo, StandardCharsets.UTF_8);
                        result.put(unCampo, unValorClave);
                        offsetcampo += longCampo;
                    }
                }
                pos++;
            }

        }catch (IOException io){
            System.out.println("Error E/S: " + io.getMessage());
        }finally {
            return result;
        }

    }
    /**
     * Insertar un nuevo registro en el fichero, siempre al final de éste.
     * @param reg Registro a insertar
     * @return posición en la que hemos insertado el registro o -1 en caso de que no se haya podido insertar
     * porque ya existe un registro que tiene el mismo valor en el campoclave
     * @throws IOException
     */
    public long insertar(HashMap<String,String> reg) throws IOException{
        String valorCampoClave = reg.get(this.campoClave);
        if (recuperar(valorCampoClave) != null){//Comprobamos si ya existe un registro con el mismo valor para el campo clave que el queremos insertar (No está permitido)
            return -1;
        }

        try(FileOutputStream fos = new FileOutputStream(nombreFich, true)){
            for (Map.Entry<String,Integer> campo: campos.entrySet()) {
                int longCampo = campo.getValue();
                String valorCampo = reg.get(campo.getKey());
                if (valorCampo == null){
                    valorCampo = "";
                }

                String valorCampoForm = String.format("%1$-" + longCampo + "s", valorCampo); //devuelve el valor del 1er argumento en un String con longitud "longCampo" y alineado a la izquierda (gracias al uso de "-")
                fos.write(valorCampoForm.getBytes("UTF-8"), 0, longCampo);
            }
        }catch (IOException e){
            System.out.println("Error de E/S: " + e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        this.numReg++;
        return  this.numReg-1;
    }

    /*public boolean modificar(String valorClave, String nombreCampo, String valorCampo) throws  IOException{
        if(nombreCampo.equals(this.campoClave)){
            System.out.println("No se puede modificar el campo clave: " + nombreCampo);
            return false;
        }
        int pos = 0;
        boolean encontrado = false;
        RandomAccessFile raf = new RandomAccessFile(this.nombreFich, "rws");
        while(pos < this.numReg && !encontrado){
            byte buffer[] = new byte[this.longReg];
            if (raf.read(buffer, 0, this.longReg) < this.longReg){
                return false;
            }
            String unValorClave = recuperarValorCampoClave(buffer);

            if(valorClave.equals(unValorClave)){
                int offsetCampo = 0;
                encontrado = true;
                raf.seek(pos*longReg);
                for(Map.Entry<String,Integer> campo: campos.entrySet()){
                    String unCampo = campo.getKey();
                    int longCampo = campo.getValue();
                    if(nombreCampo.equals(unCampo)){
                        raf.skipBytes(offsetCampo);
                        String valorCampoForm = String.format("%1$-" + longCampo + "s", valorCampo);
                        raf.write(valorCampoForm.getBytes("UTF-8"), 0, longCampo);
                        break;
                    }
                    offsetCampo += longCampo;
                }
            }
            pos++;
        }
        return encontrado;

    }*/
}
