package com.example.guiaturistico

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetalhesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val nome = intent.getStringExtra("nome") ?: ""
        val imagem = intent.getIntExtra("imagem", 0)
        val pacote = intent.getStringExtra("pacote") ?: ""
        val hotel = intent.getStringExtra("hotel") ?: ""
        val telefone = intent.getStringExtra("telefone") ?: ""
        val endereco = intent.getStringExtra("endereco") ?: ""

        findViewById<ImageView>(R.id.imgDetalhes)
            .setImageResource(imagem)

        findViewById<TextView>(R.id.txtNome).text = nome

        findViewById<TextView>(R.id.txtPacote).text =
            "${getString(R.string.pacote)}: $pacote"

        findViewById<TextView>(R.id.txtHotel).text =
            "${getString(R.string.hotel)}: $hotel"

        val txtTelefone = findViewById<TextView>(R.id.txtTelefone)
        txtTelefone.text =
            "${getString(R.string.telefone)}: $telefone"

        findViewById<TextView>(R.id.txtEndereco).text =
            "${getString(R.string.como_chegar)}: $endereco"

        txtTelefone.setOnClickListener {
            val discador = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:$telefone")
            )
            startActivity(discador)
        }

        findViewById<Button>(R.id.btnComoChegar)
            .setOnClickListener {
                val mapa = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=${Uri.encode(endereco)}")
                )

                try {
                    startActivity(mapa)
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(
                        this,
                        getString(R.string.sem_mapa),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        findViewById<Button>(R.id.btnEnviarMensagem)
            .setOnClickListener {
                val email = Intent(
                    Intent.ACTION_SENDTO,
                    Uri.parse("mailto:contato@ifsp.edu.br")
                )

                email.putExtra(
                    Intent.EXTRA_SUBJECT,
                    getString(R.string.assunto_email)
                )

                email.putExtra(
                    Intent.EXTRA_TEXT,
                    "${getString(R.string.corpo_email)}\n\nDestino: $nome"
                )

                try {
                    startActivity(email)
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(
                        this,
                        getString(R.string.sem_email),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}