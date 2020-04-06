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

import java.math.BigInteger;


public class Hashing extends AppCompatActivity {
EditText ed;
TextView tx;
Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hashing);
        ed=(EditText) findViewById(R.id.he1);
        tx=(TextView) findViewById(R.id.ht1);
        b=(Button) findViewById(R.id.hb1);

b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        byte[] s= ed.getText().toString().getBytes();
        BigInteger md5Data=null;
        try {
            md5Data = new BigInteger(1, md5.encryptMD5(s));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

            String md5 = md5Data.toString(16);
            tx.setText(md5);
        Toast.makeText(getApplicationContext(),"Retrival of text is not possible",Toast.LENGTH_LONG).show();



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
        {
            Intent intent =new Intent(this,s_encoding.class);

            startActivity(intent);
        }
        if(id==R.id.menu_about) {
        }

        return super.onOptionsItemSelected(item);

    }




}




