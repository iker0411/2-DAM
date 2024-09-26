import 'dart:io';

import 'package:verdugodart/Game.dart';

class Player {
  String palabraUsuario = "";

  void leerPorTeclado(String palabra) {
    palabra = stdin.readLineSync()!;
  }

  void devolverPalabraClave() {
    print(palabraUsuario);
  }
  void compararLetra(String palabraUsuario) {
    
  }
}
