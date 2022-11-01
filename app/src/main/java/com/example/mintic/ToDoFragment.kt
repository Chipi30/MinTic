package com.example.sweethome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.mintic.R
import androidx.fragment.app.FragmentContainer
import com.example.mintic.DetailFragment
import java.util.zip.Inflater

class ToDoFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?,
        savedInstancesState: Bundle?
    ): View?{
        val fragmento: View = inflater.inflate(R.layout.fragment_to_do,container,false)

        /*val detail1 : Button = fragmento.findViewById(R.id.btn_detail_1)
        val detail2 : Button = fragmento.findViewById(R.id.btn_detail_2)
        val detail3 : Button = fragmento.findViewById(R.id.btn_detail_3)

        detail1.setOnClickListener(View.OnClickListener {
            val datos = Bundle()
            datos.putString("Tarea",resources.getString(R.string.agendar_citaP))
            datos.putString("Hora",resources.getString(R.string.hora))
            datos.putString("Lugar",resources.getString(R.string.lugar))
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fragment_container_view, DetailFragment :: class.java, datos, "detail")
                ?.addToBackStack("")
                ?.commit()
        })

        detail2.setOnClickListener(View.OnClickListener {
            val datos = Bundle()
            datos.putString("Tarea",resources.getString(R.string.agendar_citaM))
            datos.putString("Hora",resources.getString(R.string.hora))
            datos.putString("Lugar",resources.getString(R.string.lugar))
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fragment_container_view, DetailFragment :: class.java, datos, "detail")
                ?.addToBackStack("")
                ?.commit()
        })

        detail3.setOnClickListener(View.OnClickListener {
            val datos = Bundle()
            datos.putString("Tarea",resources.getString(R.string.acompañamiento))
            datos.putString("Hora",resources.getString(R.string.hora))
            datos.putString("Lugar",resources.getString(R.string.lugar))
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fragment_container_view, DetailFragment :: class.java, datos, "detail")
                ?.addToBackStack("")
                ?.commit()
        })*/
        /*val btnDetail1: Button=fragmento.findViewById(R.id.btn_detail_1)
        val btnDetail2: Button=fragmento.findViewById(R.id.btn_detail_2)
        val btnDetail3: Button=fragmento.findViewById(R.id.btn_detail_3)
        btnDetail1.setOnClickListener(View.OnClickListener {
            val datos=Bundle()
            datos.putString("Tarea","ir al supermercado")
            datos.putString("Hora", "6:13")
            datos.putString("Lugar","Calle")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcvToDo,DetailFragment::class.java,datos,"detail")
                ?.addToBackStack("")
                ?.commit()
        })*/

        return fragmento
    }
}