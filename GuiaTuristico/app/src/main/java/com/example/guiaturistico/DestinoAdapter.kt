package com.example.guiaturistico

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class DestinoAdapter(
    private val contexto: Context,
    private val destinos: List<Destino>
) : ArrayAdapter<Destino>(contexto, 0, destinos) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view = convertView ?: LayoutInflater.from(contexto)
            .inflate(R.layout.item_destino, parent, false)

        val destino = destinos[position]

        val imagem = view.findViewById<ImageView>(R.id.imgDestino)
        val nome = view.findViewById<TextView>(R.id.txtNomeDestino)

        imagem.setImageResource(destino.imagem)
        nome.text = destino.nome

        return view
    }
}