//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    // ==========================================
    // Parte inicial do projeto
    // ==========================================

    var n1 = 12
    val n2: Int = n1
    n1 = 55

    println("Hello World")
    println("n1 = $n1")
    println("n2 = $n2")

    println("\nDigite sua idade:")
    var idade = readln().toInt()

    idade++

    println("No ano que vem sua idade será: $idade")


    // ==========================================
    // MENU DE EXERCÍCIOS
    // ==========================================

    while (true) {

        println("\n==============================")
        println("       LISTA DE EXERCÍCIOS")
        println("==============================")
        println("1 - Maiúsculas e minúsculas")
        println("2 - Soma de dois números")
        println("3 - Par ou ímpar")
        println("4 - Média das notas")
        println("5 - Conversor de temperatura")
        println("0 - Sair")
        println("==============================")
        print("Escolha uma opção: ")

        val opcao = readln().toIntOrNull()

        when (opcao) {

            // ==========================================
            // EXERCÍCIO 1
            // ==========================================
            1 -> {
                println("\n--- Exercício 1 ---")
                print("Digite uma palavra: ")

                val palavra = readln()

                println("Maiúsculas: ${palavra.uppercase()}")
                println("Minúsculas: ${palavra.lowercase()}")
            }


            // ==========================================
            // EXERCÍCIO 2
            // ==========================================
            2 -> {
                println("\n--- Exercício 2 ---")

                print("Digite o primeiro número inteiro: ")
                val numero1 = readln().toIntOrNull()

                print("Digite o segundo número inteiro: ")
                val numero2 = readln().toIntOrNull()

                if (numero1 != null && numero2 != null) {

                    val soma = numero1 + numero2

                    println("A soma é $soma")

                } else {
                    println("Entrada inválida! Digite números inteiros.")
                }
            }


            // ==========================================
            // EXERCÍCIO 3
            // ==========================================
            3 -> {
                println("\n--- Exercício 3 ---")

                print("Digite um número inteiro: ")

                val numero = readln().toIntOrNull()

                if (numero == null) {

                    println("Entrada inválida! Digite um número inteiro.")

                } else {

                    if (numero % 2 == 0) {
                        println("O número $numero é PAR.")
                    } else {
                        println("O número $numero é ÍMPAR.")
                    }
                }
            }


            // ==========================================
            // EXERCÍCIO 4
            // ==========================================
            4 -> {
                println("\n--- Exercício 4 ---")

                print("Digite a primeira nota: ")
                val nota1 = readln().toDoubleOrNull()

                print("Digite a segunda nota: ")
                val nota2 = readln().toDoubleOrNull()

                print("Digite a terceira nota: ")
                val nota3 = readln().toDoubleOrNull()

                if (nota1 == null || nota2 == null || nota3 == null) {

                    println("Entrada inválida! Digite valores decimais.")

                } else {

                    val media = (nota1 + nota2 + nota3) / 3

                    println("Média: %.2f".format(media))

                    when {
                        media >= 6 -> {
                            println("Situação: APROVADO")
                        }

                        media >= 4 -> {
                            println("Situação: RECUPERAÇÃO")
                        }

                        else -> {
                            println("Situação: REPROVADO")
                        }
                    }
                }
            }


            // ==========================================
            // EXERCÍCIO 5
            // ==========================================
            5 -> {
                println("\n--- Exercício 5 ---")

                print("Digite a temperatura em Celsius: ")

                val celsius = readln().toDoubleOrNull()

                if (celsius == null) {

                    println("Entrada inválida! Digite um número.")

                } else {

                    println("\nEscolha a conversão:")
                    println("1 - Fahrenheit")
                    println("2 - Kelvin")
                    print("Opção: ")

                    val conversao = readln().toIntOrNull()

                    when (conversao) {

                        1 -> {
                            val fahrenheit = celsius * 9 / 5 + 32

                            println(
                                "%.2f °C = %.2f °F"
                                    .format(celsius, fahrenheit)
                            )
                        }

                        2 -> {
                            val kelvin = celsius + 273.15

                            println(
                                "%.2f °C = %.2f K"
                                    .format(celsius, kelvin)
                            )
                        }

                        else -> {
                            println("Opção inválida! Escolha 1 ou 2.")
                        }
                    }
                }
            }


            // ==========================================
            // SAIR
            // ==========================================
            0 -> {
                println("\nPrograma encerrado. Até mais!")
                break
            }


            // ==========================================
            // OPÇÃO INVÁLIDA
            // ==========================================
            else -> {
                println("Opção inválida! Escolha uma opção de 0 a 5.")
            }
        }
    }
}
