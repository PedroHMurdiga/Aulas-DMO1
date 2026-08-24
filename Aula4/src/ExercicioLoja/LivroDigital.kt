package ExercicioLoja

class LivroDigital(
    nome: String,
    preco: Double,
    val email: String
) : ProdutoDigital(nome, preco) {

    override fun exibirInformacoes() {
        println(
            "Livro digital: $nome - R$ $preco - Enviado para: $email"
        )
    }
}
