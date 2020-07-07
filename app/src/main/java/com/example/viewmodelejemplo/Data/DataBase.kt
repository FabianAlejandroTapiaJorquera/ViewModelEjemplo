package com.example.viewmodelejemplo.Data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User

class DataBase {
    fun cargarDatos(): LiveData<Usuario> {
        val userLiveData = MutableLiveData<Usuario>()
        FirebaseFirestore.getInstance().collection("usuarios").document("19230622-1").get().addOnSuccessListener {
            var user = Usuario("sin nombre")
            if (it.exists()) {
                user = Usuario(it.get("nombre").toString())
            }
            userLiveData.value = user
        }
        return userLiveData
    }

}