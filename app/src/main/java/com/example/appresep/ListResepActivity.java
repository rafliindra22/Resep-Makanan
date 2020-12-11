package com.example.appresep;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListResepActivity extends AppCompatActivity {

    ListView lv;

    int[] iconList = new int[]{
            R.drawable.nasigoreng, R.drawable.nasiliwet, R.drawable.nasiuduk, R.drawable.ayamgoreng,
            R.drawable.sayursup
    };

    String[] Headline = {"Nasi Goreng", "Nasi Liwet", "Nasi Uduk", "Ayam Geprek", "Sayur Sop"

    };

    String[] Subhead = {"Resep Cara membuat Nasi Goreng", "Resep Cara membuat Nasi Liwet",
            "Resep Cara membuat Nasi Uduk", "Resep Cara membuat Ayam Geprek",
            "Resep Cara membuat Sayur Sop"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.list);
        ListAdapter listAdapter = new ListAdapter(this, iconList, Headline, Subhead);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),
                        "You have selected : " + Headline[position],
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}