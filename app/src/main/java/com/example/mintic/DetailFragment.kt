package com.example.sweethome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mintic.R

class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.fragment_detail,container,false)

        var tarea = requireArguments().getString("Tarea")
        var hora = requireArguments().getString("Hora")
        var lugar = requireArguments().getString("Lugar")

        var textViewTarea: TextView = fragmento.findViewById(R.id.textViewTarea)
        var textViewHora: TextView = fragmento.findViewById(R.id.textViewHora)
        var textViewLugar: TextView = fragmento.findViewById(R.id.textViewLugar)

        textViewTarea.text = tarea
        textViewHora.text = hora
        textViewLugar.text = lugar

        return fragmento
    }
}