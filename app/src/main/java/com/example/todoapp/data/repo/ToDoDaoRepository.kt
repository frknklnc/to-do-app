package com.example.todoapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.room.ToDoDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoDaoRepository(var tdao:ToDoDao) {
    var jobListesi:MutableLiveData<List<ToDo>>
    init {
        jobListesi = MutableLiveData()
    }

    fun joblariGetir(): MutableLiveData<List<ToDo>>{
        return jobListesi
    }


    fun jobKayit(yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniJob = ToDo(0,yapilacak_is)
            tdao.jobEkle(yeniJob)
        }
    }

    fun jobGuncelle(yapilacak_id:Int,yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenJob = ToDo(yapilacak_id,yapilacak_is)
            tdao.jobGuncelle(guncellenenJob)
        }

    }

    fun jobAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            jobListesi.value = tdao.jobAra(aramaKelimesi)
        }
    }

    fun jobSil(yapilacak_id: Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenJob = ToDo(yapilacak_id,"")
            tdao.jobSil(silinenJob)
            tumJoblariAl()
        }

    }

    fun tumJoblariAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            jobListesi.value = tdao.tumJob()
        }
    }
}