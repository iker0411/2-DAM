import 'dart:ffi';
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
}
