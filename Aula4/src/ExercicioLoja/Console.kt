package ExercicioLoja

class Console(
    nome: String,
    preco: Double,
    peso: Double
) : ProdutoFisico(nome, preco, peso) {

    override fun exibirInformacoes() {
        println(
            "Console: $nome - R$ $preco - Peso: ${peso}kg"
        )
    }
}
