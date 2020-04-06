package com.example.home.security;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Date;
import java.util.Base64;


import java.util.Random;

public class s_encoding0 extends AppCompatActivity {
EditText se1;
TextView st1;
Button sb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_encoding0);
        se1=(EditText) findViewById(R.id.se1);
        st1=(TextView) findViewById(R.id.st1);
        sb1=(Button) findViewById(R.id.sb1);

        sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String s= se1.getText().toString();
                Random random = new Random((new Date()).getTime());
                byte[] salt = new byte[8];
                random.nextBytes(salt);
                final String s1= new String(salt);
                String s3= s+s1;
                byte b[] = Base64.getEncoder().encode(s3.getBytes());
                String s4= new String(b);
                st1.setText(s4);






            }
        });





    }


}
