open class Pessoa {

//    Propriedades de uma pessoa
    var cpf: String  = ""
    var nome: String = ""
    var email: String = ""

    constructor(cpf: String, nome: String, email: String) {
        this.cpf = cpf
        this.nome = nome
        this.email = email
    }

    constructor(){}

    open fun andar(){
//        super.andar
        println("Andando...")
    }
}