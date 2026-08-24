package ExercicioLoja

abstract class Produto(
    val nome: String,
    val preco: Double
) {
    abstract fun exibirInformacoes()

    open fun calcularFrete(): Double {
        return 0.0
    }
}
