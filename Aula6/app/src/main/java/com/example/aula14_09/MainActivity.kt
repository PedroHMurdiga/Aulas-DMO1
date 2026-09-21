package com.example.aula14_09

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ConversorMoedaActivity : AppCompatActivity() {

    companion object {
        const val DOLAR = 5.20
        const val EURO = 6.00
    }

    private val nomeAplicativo = "Conversor de Moedas"
    private var ultimaConversao = 0.0
    private lateinit var ivBandeiraOrigem: ImageView
    private lateinit var ivBandeiraDestino: ImageView
    private lateinit var btnInverter: Button
    private lateinit var etValor: EditText
    private lateinit var spOrigem: Spinner
    private lateinit var spDestino: Spinner
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpar: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setupViews()
        setupListeners()
    }

    private fun setupViews() {

        ivBandeiraOrigem = findViewById(R.id.ivBandeiraOrigem)
        ivBandeiraDestino = findViewById(R.id.ivBandeiraDestino)
        btnInverter = findViewById(R.id.btnInverter)
        etValor = findViewById(R.id.etValor)
        spOrigem = findViewById(R.id.spOrigem)
        spDestino = findViewById(R.id.spDestino)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpar = findViewById(R.id.btnLimpar)
        tvResultado = findViewById(R.id.tvResultado)

        val moedas = arrayOf(
            "Real",
            "Dólar",
            "Euro"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            moedas
        )
        spOrigem.adapter = adapter
        spDestino.adapter = adapter
        spOrigem.setSelection(0)
        spDestino.setSelection(1)
        atualizarBandeiras()
    }

    private fun setupListeners() {
        btnCalcular.setOnClickListener {
            converterMoeda()
        }
        btnLimpar.setOnClickListener {
            etValor.text.clear()
            tvResultado.text = ""
        }
        btnInverter.setOnClickListener {
            inverterMoedas()
        }

        spOrigem.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: android.view.View?,
                    position: Int,
                    id: Long
                ) {
                    atualizarBandeiras()
                }
                override fun onNothingSelected(
                    parent: AdapterView<*>?
                ) {
                }
            }

        spDestino.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: android.view.View?,
                    position: Int,
                    id: Long
                ) {
                    atualizarBandeiras()
                }
                override fun onNothingSelected(
                    parent: AdapterView<*>?
                ) {
                }
            }
    }

    private fun atualizarBandeiras() {

        val origem = spOrigem.selectedItem.toString()
        val destino = spDestino.selectedItem.toString()

        if (origem == "Real") {
            ivBandeiraOrigem.setImageResource(
                R.drawable.bandeira_brasil
            )
        } else if (origem == "Dólar") {
            ivBandeiraOrigem.setImageResource(
                R.drawable.bandeira_eua
            )
        } else {
            ivBandeiraOrigem.setImageResource(
                R.drawable.bandeira_euro
            )
        }

        if (destino == "Real") {
            ivBandeiraDestino.setImageResource(
                R.drawable.bandeira_brasil
            )
        } else if (destino == "Dólar") {
            ivBandeiraDestino.setImageResource(
                R.drawable.bandeira_eua
            )
        } else {
            ivBandeiraDestino.setImageResource(
                R.drawable.bandeira_euro
            )
        }
    }

    private fun converterMoeda() {

        if (etValor.text.isEmpty()) {
            Toast.makeText(
                this,
                "Digite um valor",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val valor = etValor.text.toString().toDoubleOrNull()

        if (valor == null || valor <= 0) {
            Toast.makeText(
                this,
                "Digite um valor válido",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        val origem = spOrigem.selectedItem.toString()
        val destino = spDestino.selectedItem.toString()

        if (origem == destino) {
            Toast.makeText(
                this,
                "Escolha moedas diferentes",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        val valorReal: Double

        if (origem == "Real") {
            valorReal = valor
        } else if (origem == "Dólar") {
            valorReal = valor * DOLAR
        } else {
            valorReal = valor * EURO
        }
        val resultado: Double

        if (destino == "Real") {
            resultado = valorReal
        } else if (destino == "Dólar") {
            resultado = valorReal / DOLAR
        } else {
            resultado = valorReal / EURO
        }
        ultimaConversao = resultado

        tvResultado.text =
            "$destino: %.2f".format(resultado)
    }

    private fun inverterMoedas() {

        val origem = spOrigem.selectedItemPosition
        val destino = spDestino.selectedItemPosition

        spOrigem.setSelection(destino)
        spDestino.setSelection(origem)

        tvResultado.text = ""

        atualizarBandeiras()
    }
}