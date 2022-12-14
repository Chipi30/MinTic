package com.example.mintic

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.mintic.room_database.ToDoDaD
import com.example.mintic.room_database.ToDoDataBase
import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ToDoFragment : Fragment(){
    private lateinit var listRecyclerView: RecyclerView
    private lateinit var myAdapter : RecyclerView.Adapter<MyTaskListAdapter.MyViewHolder>
    var myTaskTitles : ArrayList<String> = ArrayList()
    var myTaskTime : ArrayList<String> = ArrayList()
    var myTaskPlace : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstancesState: Bundle?
    ): View? {
        val fragmento: View = inflater.inflate(R.layout.fragment_to_do,container,false)

        return fragmento

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
            datos.putString("Tarea",resources.getString(R.string.acompa??amiento))
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


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* var myTaskTitles : ArrayList<String> = ArrayList()
        var myTaskTime : ArrayList<String> = ArrayList()
        var myTaskPlace : ArrayList<String> = ArrayList()

        myTaskTitles.add("ir al super")
        myTaskTitles.add("ir al super")

        myTaskTime.add("11:00")
        myTaskTime.add("11:00")

        myTaskPlace.add("casa")
        myTaskPlace.add("casa")

        var info : Bundle =Bundle()
        info.putStringArrayList("titles",myTaskTitles)
        info.putStringArrayList("time",myTaskTime)
        info.putStringArrayList("places",myTaskPlace)
        listRecyclerView =requireView().findViewById(R.id.recycleToDoList)
        myAdapter = MyTaskListAdapter(activity as AppCompatActivity,info)
        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter = myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))*/
        val fab : View = requireActivity().findViewById((R.id.fabToDo))
        fab.setOnClickListener { view->
            val intent =Intent(activity,NewTaskActivity::class.java)
            var recursiveScope = 0
            startActivityForResult(intent,recursiveScope)
        }
        var info : Bundle =Bundle()
        info.putStringArrayList("titles",myTaskTitles)
        info.putStringArrayList("times",myTaskTime)
        info.putStringArrayList("places",myTaskPlace)
        listRecyclerView =requireView().findViewById(R.id.recycleToDoList)
        myAdapter = MyTaskListAdapter(activity as AppCompatActivity,info)
        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter = myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        updateList()
    }

    fun updateList(){
        val db= ToDoDataBase.getDatabase(requireActivity())
        val toDoDAD= db.todoDao()
        runBlocking{
            launch{
                var result = ToDoDaD.getAllTasks()
                var i=0
                myTaskTitles.clear()
                myTaskTime.clear()
                myTaskPlace.clear()
                while (i< result.size){
                    myTaskTitles.add(result[i].title.toString())
                    myTaskTime.add(result[i].time.toString())
                    myTaskPlace.add(result[i].place.toString())
                    i++
                }
                myAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==0){
            if(resultCode==Activity.RESULT_OK){
                updateList()
            }

        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}