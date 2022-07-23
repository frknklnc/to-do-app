package com.example.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.ToDoDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KayitFragmentViewModel @Inject constructor(var trepo: ToDoDaoRepository): ViewModel() {
    fun kayit(yapilacak_is:String){
        trepo.jobKayit(yapilacak_is)

    }
}