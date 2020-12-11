package com.example.appresep

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appresep.Adapter
import com.example.appresep.helper.Constant
import com.example.appresep.helper.PreferencesHelper

class UserActivity : AppCompatActivity() {



    lateinit var recyclerView: RecyclerView
    lateinit var adapter: Adapter


    lateinit var sharedpref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)


        sharedpref = PreferencesHelper(this)

        val textUsername = findViewById(R.id.textUsername) as TextView
        val buttonLogout = findViewById(R.id.buttonLogout) as Button
        val toListResep = findViewById(R.id.buttnToListResep) as Button

        textUsername.text = sharedpref.getString(Constant.PREF_USERNAME)

        buttonLogout.setOnClickListener{
            sharedpref.clear()
            showMessage("Keluar")
            moveIntent()
        }

        toListResep.setOnClickListener{
            sharedpref.clear()
            showMessage("List Resep")
            moveToListResep()
        }

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun moveToListResep(){
        startActivity(Intent(this, ListResepActivity::class.java))
    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun showMessage(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    private fun init() {
        recyclerView = findViewById(R.id.list)

        var data = ArrayList<Resep>()
        data.add(Resep(R.drawable.nasigoreng, "Sayur Lodeh", "Cara membuat sayur lodeh yang lezat"))
        data.add(Resep(R.drawable.nasiliwet, "Ayam Katsu", "Cara membuat ayam katsu seperti di restoran"))
        data.add(Resep(R.drawable.nasiuduk, "Bakwan Mie Sayur", "Cara membuat bakwan mie sayur kekinian"))
        data.add(Resep(R.drawable.ayamgoreng, "Ayam Crispy", "Cara membuat ayam goreng krispi"))
        data.add(Resep(R.drawable.sayursup, "Mie Ramen", "Cara membuat mie ramen seperti aslinya"))

        adapter = Adapter(data)
    }

}