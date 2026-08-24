import kotlin.js.ExperimentalJsReflectionCreateInstance

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val p1 = Pessoa("123445678","Pedro","Pedro@gmail.com")

    p1.nome = "Pedro"
    p1.cpf = "123445678"
    p1.email = "Pedro@gmail.com"

    println("Nome: " + p1.nome)
    println("Cpf: " + p1.cpf)
    println("Email: " + p1.email)

//    Criando uma criança
    val c1 = Crianca()
    c1.nome = "Oswalo"
    c1.cpf = "987654321"
    c1.reuPrimario = false
    p1.andar()
    c1.andar()

    c1.mover()
    c1.som()
    c1.respirar()

    val c2 = Adolescente()
    c2.idioma = "Mandarim"
    c2.cumprimentar()
    c2.praticarHobby()
}