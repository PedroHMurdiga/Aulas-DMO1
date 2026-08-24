package ExercicioLoja

class Pedido(
    val cliente: Cliente
) {

    private val produtos = mutableListOf<Produto>()

    private var cupom: Cupom? = null

    fun adicionarProduto(produto: Produto) {
        produtos.add(produto)
    }

    fun aplicarCupom(cupom: Cupom) {
        this.cupom = cupom
    }

    private fun calcularSubtotal(): Double {
        return produtos.sumOf { it.preco }
    }

    private fun calcularFrete(): Double {
        return produtos.sumOf { it.calcularFrete() }
    }

    private fun calcularDesconto(): Double {
        val percentual = cupom?.percentualDesconto ?: 0.0

        return calcularSubtotal() * percentual / 100
    }

    private fun calcularTotal(): Double {
        return calcularSubtotal() -
                calcularDesconto() +
                calcularFrete()
    }

    fun exibirResumo() {

        println("========================================")
        println("           RESUMO DO PEDIDO")
        println("========================================")

        println("\nCLIENTE")
        println("Nome: ${cliente.nome}")
        println("E-mail: ${cliente.email}")

        println("\nPRODUTOS")

        produtos.forEach { produto ->
            produto.exibirInformacoes()
        }

        val subtotal = calcularSubtotal()
        val desconto = calcularDesconto()
        val frete = calcularFrete()
        val total = calcularTotal()

        println("\nVALORES")
        println("Subtotal: R$ %.2f".format(subtotal))
        println("Desconto: R$ %.2f".format(desconto))
        println("Frete: R$ %.2f".format(frete))
        println("Total: R$ %.2f".format(total))

        if (cupom != null) {
            println("Cupom aplicado: ${cupom!!.codigo}")
            println(
                "Percentual de desconto: ${cupom!!.percentualDesconto}%"
            )
        }

        println("========================================")
    }
}
