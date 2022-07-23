package com.example.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.databinding.CardTasarimBinding
import com.example.todoapp.databinding.FragmentAnasayfaBinding
import com.example.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.example.todoapp.ui.viewmodel.AnasayfaFragmentViewModel
import com.example.todoapp.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(var mContext: Context, var yapilacakIsListesi:List<ToDo>,
                  var viewModel: AnasayfaFragmentViewModel)
    : RecyclerView.Adapter<ToDoAdapter.CardTasarimTutucu>(){
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim:CardTasarimBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu((tasarim)) // Card tasarim için viewbinding kurulumu
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val job = yapilacakIsListesi.get(position)
        val t = holder.tasarim
        t.jobNesnesi = job
        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(job = job)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${job.yapilacak_is} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(job.yapilacak_id)
                }.show()

        }
    }

    override fun getItemCount(): Int {
        return yapilacakIsListesi.size
    }

}