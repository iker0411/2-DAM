import 'dart:io';
void main() {
  var cocodrilloroso= 0;
  List<String> vocales = ["a", "e", "i", "o", "u"];
  print("Dime el número que hay de cocodrilos:");
 var sc = stdin.readByteSync();
  do{
    var sc = stdin.readByteSync();
    if(sc < 1 || sc > 50){
      print("No puede ser inferior a 1 ni superior a 50");
    }
  }while(sc < 1 || sc > 50);
  for(int i= 0 ;i < sc; i++){
     print("Dime el nombre del cocodrilo");
     

  }
}
