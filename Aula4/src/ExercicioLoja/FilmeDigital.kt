package ExercicioLoja

class FilmeDigital(
    nome: String,
    preco: Double
) : ProdutoDigital(nome, preco) {

    override fun exibirInformacoes() {
        println(
            "Filme digital: $nome - R$ $preco - Disponível no player online"
        )
    }
}
