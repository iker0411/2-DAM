import 'dart:io';

//import 'package:verdugodart/Game.dart';

class Player {
  String palabraUsuario = "";

  void leerPorTeclado() {
    palabraUsuario = stdin.readLineSync()!;
  }

  String devolverPalabraClave() {
    return(palabraUsuario);
  }
 
}
