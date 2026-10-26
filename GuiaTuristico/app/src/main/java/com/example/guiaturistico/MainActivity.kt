package com.example.guiaturistico

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var lista: ListView

    private val destinos = mutableListOf<Destino>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarDestinos()

        lista = findViewById(R.id.listaDestinos)

        val adapter = DestinoAdapter(this, destinos)
        lista.adapter = adapter

        lista.setOnItemClickListener { _, _, position, _ ->
            val destino = destinos[position]

            val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("nome", destino.nome)
            intent.putExtra("imagem", destino.imagem)
            intent.putExtra("pacote", destino.pacote)
            intent.putExtra("hotel", destino.hotel)
            intent.putExtra("telefone", destino.telefone)
            intent.putExtra("endereco", destino.endereco)

            startActivity(intent)
        }
    }

    private fun carregarDestinos() {
        destinos.add(
            Destino(
                getString(R.string.araraquara),
                R.drawable.araraquara,
                "Pacote de 2 dias, com passeios pela cidade.",
                "Hotel Dan Inn Araraquara",
                "+55 16 3333-0000",
                "Araraquara, SP, Brasil"
            )
        )

        destinos.add(
            Destino(
                getString(R.string.sao_paulo),
                R.drawable.sao_paulo,
                "Pacote de 3 dias, com passeios urbanos.",
                "Hotel no centro de São Paulo",
                "+55 11 4000-0000",
                "São Paulo, SP, Brasil"
            )
        )

        destinos.add(
            Destino(
                getString(R.string.rio_de_janeiro),
                R.drawable.rio_de_janeiro,
                "Pacote de 4 dias, com praias e pontos turísticos.",
                "Hotel em Copacabana",
                "+55 21 4000-0000",
                "Rio de Janeiro, RJ, Brasil"
            )
        )

        destinos.add(
            Destino(
                getString(R.string.salvador),
                R.drawable.salvador,
                "Pacote de 3 dias, com passeios históricos.",
                "Hotel no centro de Salvador",
                "+55 71 4000-0000",
                "Salvador, BA, Brasil"
            )
        )

        destinos.add(
            Destino(
                getString(R.string.curitiba),
                R.drawable.curitiba,
                "Pacote de 3 dias, com parques e museus.",
                "Hotel no centro de Curitiba",
                "+55 41 4000-0000",
                "Curitiba, PR, Brasil"
            )
        )

        destinos.add(
            Destino(
                getString(R.string.florianopolis),
                R.drawable.florianopolis,
                "Pacote de 4 dias, com praias e trilhas.",
                "Hotel próximo à praia",
                "+55 48 4000-0000",
                "Florianópolis, SC, Brasil"
            )
        )

        destinos.add(
            Destino(
                getString(R.string.foz_iguacu),
                R.drawable.foz_iguacu,
                "Pacote de 3 dias, com visita às cataratas.",
                "Hotel próximo ao centro",
                "+55 45 4000-0000",
                "Foz do Iguaçu, PR, Brasil"
            )
        )

        destinos.add(
            Destino(
                getString(R.string.gramado),
                R.drawable.gramado,
                "Pacote de 3 dias, com passeios pela Serra Gaúcha.",
                "Hotel no centro de Gramado",
                "+55 54 4000-0000",
                "Gramado, RS, Brasil"
            )
        )

        destinos.add(
            Destino(
                getString(R.string.brasilia),
                R.drawable.brasilia,
                "Pacote de 2 dias, com passeios arquitetônicos.",
                "Hotel no centro de Brasília",
                "+55 61 4000-0000",
                "Brasília, DF, Brasil"
            )
        )

        destinos.add(
            Destino(
                getString(R.string.fernando_noronha),
                R.drawable.fernando_noronha,
                "Pacote de 5 dias, com praias e passeios naturais.",
                "Pousada na ilha",
                "+55 81 4000-0000",
                "Fernando de Noronha, PE, Brasil"
            )
        )
    }
}