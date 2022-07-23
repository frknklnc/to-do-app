package com.example.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.data.repo.ToDoDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfaFragmentViewModel @Inject constructor(var trepo: ToDoDaoRepository): ViewModel() {
    var jobListesi = MutableLiveData<List<ToDo>>()

    init {
        jobYukle()
        jobListesi = trepo.joblariGetir()

    }

    fun ara(aramaKelimesi:String){
        trepo.jobAra(aramaKelimesi)
    }

    fun sil(yapilacak_id:Int){
        trepo.jobSil(yapilacak_id)
    }

    fun jobYukle(){
        trepo.tumJoblariAl()
    }
}