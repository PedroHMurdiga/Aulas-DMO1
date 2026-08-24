//fun main(){
//
// val lista = mutableListOf()
//
// for (i in 1..5){
// println("Digite 1 numero inteiro.")
// val num = readln().toInt()
// lista.add(num)
// }
//
// retornarPar(lista)
//}
//
//fun retornarPar(numeros: MutableList){
// for (numero in numeros){
// if(numero % 2 == 0){
// println(numero)
// }
// }
//}

fun main() {
    println("Digite uma frase: ")
    var frase = readln()

    var estrutura = listOf<String>()
    estrutura = frase.split(" ");

    for (est in estrutura) {
        println(est);
    }
}