package ExercicioLoja

import java.security.Principal

abstract class ProdutoFisico(nome: String, preco: Double, val peso: Double) : Produto(nome, preco) {

    override fun calcularFrete(): Double {
        return peso * 5.0
    }
}
