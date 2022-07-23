package com.example.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.ToDoDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel @Inject constructor (var trepo: ToDoDaoRepository): ViewModel() {
    fun guncelle(yapilacak_id:Int,yapilacak_is:String){
        trepo.jobGuncelle(yapilacak_id,yapilacak_is)

    }
}