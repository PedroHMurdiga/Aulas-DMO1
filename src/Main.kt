//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var n1 = 12;
    val n2: Int = n1;
    n1 = 55;

    println("Hello World");
    println(n1);
    println(n2);

    //===============
    //Leitura de dados
    println("Digite sua idade:");
    var idade = readln().toInt();

    idade++;
    println("No ano que vem sua idadde será:" + idade);

}