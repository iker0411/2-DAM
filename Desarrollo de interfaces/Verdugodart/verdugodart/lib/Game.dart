
import 'dart:io';

class Game {
  static String palabrasClave = "";
  int contIntentos = 7;

  Game(palabrasClave);

  Game.MaxIntentos(palabrasClave, this.contIntentos);

  bool encontrarPalabra(String palabrasClave) {
    return true;
  }

  static void introducirPalabraClave() {
    //String? palabra = stdin.readLineSync();
    //this.palabrasClave = palabra!;

    palabrasClave = stdin.readLineSync()!;
  }

  static void devolverPalabraClave() {
    print(palabrasClave);
  }

  String compararLetras(String palabraUsuario) {
    List<String> letrasMencionadas = [];
    int cont = 0;
    int numMax = devolvernumeroLetras();
    String resultado = "COLGANDO";
    for (var i = 0; i < palabraUsuario.length; i++) {
      if (!letrasMencionadas.contains(palabraUsuario[i])) {
        letrasMencionadas.add(palabraUsuario[i]);
      }
    }
    for (var letter in letrasMencionadas) {
      if (!palabraUsuario.contains(letter)) {
        contIntentos--;
        if (contIntentos == 0) {
         resultado = "AHORCADO";          
         break;
        }
      } else {
        cont++;
        if(cont ==  numMax){
          resultado = "SALVADO";
          break;
        }
      }
    }
    return resultado;
  }

  int devolvernumeroLetras() {
    Set<String> setPalabra = {};
    for (var i = 0; i < palabrasClave.length; i++) {
      setPalabra.add(palabrasClave[i]);
    }
    return setPalabra.length;
  }
}
