import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
            result = null;
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
}
