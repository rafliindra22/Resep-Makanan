package com.example.appresep

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import com.example.appresep.helper.Constant
import com.example.appresep.helper.PreferencesHelper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    lateinit var sharedpref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedpref = PreferencesHelper(this)

        val buttonLogin = findViewById(R.id.buttonLogin) as Button
        val editUsername = findViewById(R.id.editUsername) as EditText
        val editPassword = findViewById(R.id.editPassword) as EditText

        buttonLogin.setOnClickListener{
            if (editUsername.text.isNotEmpty() && editPassword.text.isNotEmpty()){
                saveSession(editUsername.text.toString(), editPassword.text.toString())
                showMessage("Berhasil Masuk")
                moveIntent()
            }
        }


    }

    override fun onStart() {
        super.onStart()
        if (sharedpref.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }

    }

    private fun moveIntent(){
        startActivity(Intent(this, UserActivity::class.java))
        finish()
    }

    private fun saveSession(username: String, password: String){
        sharedpref.put(Constant.PREF_USERNAME, username)
        sharedpref.put(Constant.PREF_PASSWORD, password)
        sharedpref.put(Constant.PREF_IS_LOGIN, true)
    }

    private fun showMessage(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

}