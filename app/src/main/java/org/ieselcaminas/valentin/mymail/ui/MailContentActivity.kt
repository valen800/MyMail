package org.ieselcaminas.valentin.mymail.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.ieselcaminas.valentin.mymail.R


class MailContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail_content)

        //Localizamos los controlesee
        //Localizamos los controles
        val toolMensaje: TextView = findViewById(R.id.textBodyMailContent) as TextView

//Accedemos al Intent que ha originado la primera actividad y recuperamos la información asociada
        //Accedemos al Intent que ha originado la primera actividad y recuperamos la información asociada
        val bundle = intent.extras

//Mostramos los datos
        //Mostramos los datos
        toolMensaje.text = (bundle!!.getString("NOM"))

    }
}
