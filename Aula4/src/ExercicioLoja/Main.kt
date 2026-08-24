package ExercicioLoja

fun main() {

    val cliente = Cliente(
        nome = "João da Silva",
        email = "joao@email.com"
    )

    val pedido = Pedido(cliente)

    val livroFisico = LivroFisico(
        nome = "Kotlin para Iniciantes",
        preco = 80.0,
        peso = 0.5
    )

    val livroDigital = LivroDigital(
        nome = "Programação Orientada a Objetos",
        preco = 40.0,
        email = cliente.email
    )

    val console = Console(
        nome = "PlayStation 5",
        preco = 3500.0,
        peso = 4.5
    )

    val filme = FilmeDigital(
        nome = "O Senhor dos Anéis",
        preco = 30.0
    )

    val jogoTabuleiro = Jogo(
        nome = "Catan",
        preco = 200.0,
        tipo = TipoJogo.TABULEIRO,
        peso = 1.2
    )

    val jogoMidiaFisica = Jogo(
        nome = "Minecraft",
        preco = 150.0,
        tipo = TipoJogo.DIGITAL_MIDIA_FISICA,
        peso = 0.1
    )

    val jogoDownload = Jogo(
        nome = "Hades",
        preco = 100.0,
        tipo = TipoJogo.DIGITAL_DOWNLOAD,
        email = cliente.email
    )

    pedido.adicionarProduto(livroFisico)
    pedido.adicionarProduto(livroDigital)
    pedido.adicionarProduto(console)
    pedido.adicionarProduto(filme)
    pedido.adicionarProduto(jogoTabuleiro)
    pedido.adicionarProduto(jogoMidiaFisica)
    pedido.adicionarProduto(jogoDownload)

    val cupom = Cupom(
        codigo = "DESCONTO10",
        percentualDesconto = 10.0
    )

    pedido.aplicarCupom(cupom)

    pedido.exibirResumo()
}
