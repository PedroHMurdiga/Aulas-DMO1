package ExercicioLoja

class Jogo(
    nome: String,
    preco: Double,
    val tipo: TipoJogo,
    val peso: Double = 0.0,
    val email: String = ""
) : Produto(nome, preco) {

    init {
        require(peso >= 0) {
            "O peso não pode ser negativo."
        }

        if (
            tipo == TipoJogo.TABULEIRO ||
            tipo == TipoJogo.DIGITAL_MIDIA_FISICA
        ) {
            require(peso > 0) {
                "Jogos físicos devem possuir peso maior que zero."
            }
        }

        if (tipo == TipoJogo.DIGITAL_DOWNLOAD) {
            require(email.isNotBlank()) {
                "Jogos para download precisam de um e-mail."
            }
        }
    }

    override fun calcularFrete(): Double {
        return if (
            tipo == TipoJogo.TABULEIRO ||
            tipo == TipoJogo.DIGITAL_MIDIA_FISICA
        ) {
            peso * 5.0
        } else {
            0.0
        }
    }

    override fun exibirInformacoes() {
        when (tipo) {

            TipoJogo.TABULEIRO -> {
                println(
                    "Jogo de tabuleiro: $nome - R$ $preco - Peso: ${peso}kg"
                )
            }

            TipoJogo.DIGITAL_MIDIA_FISICA -> {
                println(
                    "Jogo digital em mídia física: $nome - R$ $preco - Peso: ${peso}kg"
                )
            }

            TipoJogo.DIGITAL_DOWNLOAD -> {
                println(
                    "Jogo digital para download: $nome - R$ $preco - Enviado para: $email"
                )
            }
        }
    }
}
