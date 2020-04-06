package com.example.home.security;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.security.Security;

public class basicpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basicpage);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(basicpage.this, Hashing.class);
                    startActivity(intent);
                }
                if (position == 2){
                    Intent intent =new Intent(basicpage.this, Encryption.class);
                    startActivity(intent);
                }
                if(position== 1)
                {
                    Intent intent =new Intent(basicpage.this, asymmetric.class);
                    startActivity(intent);
                }
                if(position == 3) {
                    Intent intent = new Intent(basicpage.this, Encoding.class);
                    startActivity(intent);
                }

            }


        };
        ListView listView = (ListView) findViewById(R.id.options);
        listView.setOnItemClickListener(itemClickListener);



    }
}
