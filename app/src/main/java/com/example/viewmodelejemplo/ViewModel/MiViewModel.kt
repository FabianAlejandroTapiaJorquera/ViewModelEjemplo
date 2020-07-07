package com.example.viewmodelejemplo.ViewModel

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.viewmodelejemplo.Data.DataBase
import com.example.viewmodelejemplo.Data.Usuario

class MiViewModel: ViewModel() {

    val usuario = MutableLiveData<Usuario>()

    fun obtenerUsuario(): LiveData<Usuario>{
        DataBase().cargarDatos().observeForever(Observer {
            usuario.value = it
        })
        return usuario
    }

}