package com.example.home.security;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.Base64;
import java.util.Random;
import java.util.Date;


public class s_encoding extends AppCompatActivity {

    TextView ts1;
    EditText es1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_encoding);
         b1=(Button) findViewById(R.id.bs1);
        es1= (EditText ) findViewById(R.id.es1);
        ts1=(TextView ) findViewById(R.id.ts1);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               byte[] salt =new byte[8];
               Random random =new Random((new Date()).getTime() );
               random.nextBytes(salt);
               byte[] s = es1.getText().toString().getBytes();
               BigInteger md5Data=null;
               try {
                   md5Data = new BigInteger(1, md5.encryptMD5(s));
               }
               catch(Exception e)
               {
                   e.printStackTrace();
               }

               String md52 = md5Data.toString(16);
               BigInteger md5Data1=null;
               try {
                   md5Data1 = new BigInteger(1,md5.encryptMD5(salt));
               }
               catch(Exception e)
               {
                   e.printStackTrace();
               }

               String md51 = md5Data1.toString(16);
               String k=md51+md52;
               ts1.setText(k);
               Toast.makeText(getApplicationContext(),"Retrival of text cannot be done",Toast.LENGTH_LONG).show();










           }
       });














    }











}
