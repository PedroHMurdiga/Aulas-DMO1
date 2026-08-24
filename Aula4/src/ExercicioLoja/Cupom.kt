package ExercicioLoja

data class Cupom(
    val codigo: String,
    val percentualDesconto: Double
) {

    init {
        require(percentualDesconto in 0.0..100.0) {
            "O percentual de desconto deve estar entre 0 e 100."
        }
    }
}
