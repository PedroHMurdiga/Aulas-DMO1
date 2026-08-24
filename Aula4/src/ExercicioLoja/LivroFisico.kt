package ExercicioLoja

class LivroFisico(
    nome: String,
    preco: Double,
    peso: Double
) : ProdutoFisico(nome, preco, peso) {

    override fun exibirInformacoes() {
        println(
            "Livro físico: $nome - R$ $preco - Peso: ${peso}kg"
        )
    }
}
