package com.example.viewmodelejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelejemplo.Data.Usuario
import com.example.viewmodelejemplo.ViewModel.MiViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var user: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MiViewModel by viewModels()
        model.obtenerUsuario().observe(this, Observer { usuario->
            nombre.text = usuario.nombre
        })
    }
}