//import 'verdugodart/verdugodart.dart';

import 'package:verdugodart/Game.dart';
import 'package:verdugodart/Player.dart';

void main(List<String> arguments) {
  Game.introducirPalabraClave();
  Game.devolverPalabraClave();
  Game game = Game(Game.palabrasClave);
  Player player = Player();
  player.leerPorTeclado();

  while (player.devolverPalabraClave() != ".") {
    print(game.compararLetras(player.palabraUsuario));
    player.leerPorTeclado();
  }
}
