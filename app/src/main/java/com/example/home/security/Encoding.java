package com.example.home.security;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Base64;

public class Encoding extends AppCompatActivity {
    TextView t2;
    TextView t1;
    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoding);
        Button b=(Button) findViewById(R.id.b1);
         e= (EditText ) findViewById(R.id.e1);
         t1=(TextView ) findViewById(R.id.t1);
         t2=(TextView) findViewById(R.id.t2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String s1 = e.getText().toString();
                byte[]  b =    Base64.getEncoder().encode(s1.getBytes());
                String s2 = new String(b);
                t2.setText(s2);
                byte[] decoded = Base64.getDecoder().decode(s2);
                String s3= new String(decoded);
                t1.setText(s3);



            }
        });

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_items,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.menu_salt)
        {Intent intent =new Intent(Encoding.this,s_encoding0.class);
        startActivity(intent);

        }
        if(id==R.id.menu_about) {
        }

        return super.onOptionsItemSelected(item);

    }
}
