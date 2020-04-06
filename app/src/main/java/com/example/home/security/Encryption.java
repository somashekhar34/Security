package com.example.home.security;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class Encryption extends AppCompatActivity {
EditText ee1,ee2;
Button eb1,eb2;
TextView et1;
String AES="AES";
String outputString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);
        ee1 =(EditText)findViewById(R.id.ee1);
        ee2= (EditText)findViewById(R.id.ee2);
        et1=(TextView)findViewById(R.id.et1);
        eb1=(Button)findViewById(R.id.eb1);
eb2=(Button)findViewById(R.id.eb2);

eb1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

try {
    outputString = encrypt(ee1.getText().toString(), ee2.getText().toString());
    et1.setText(outputString);
}
catch(Exception e)
{
    e.printStackTrace();;
}

eb2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        try {
            outputString = descrypt(outputString, ee2.getText().toString());
        } catch (Exception e) {

            Toast.makeText(Encryption.this,"Wrong key",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        et1.setText(outputString);

    }
});


















    }
});























    }

    private String descrypt(String s, String s1) throws Exception{
        SecretKeySpec key=generateKey(s1);
        Cipher c= Cipher.getInstance(AES);
         c.init(Cipher.DECRYPT_MODE,key);
         byte[] dec= Base64.decode(s,Base64.DEFAULT);
         byte[] devalue = c.doFinal(dec);
         String s2 =new String(devalue);
         return s2;
    }

    private String encrypt(String s, String s1)throws Exception {
        SecretKeySpec key=generateKey(s1);
        Cipher c= Cipher.getInstance(AES);
        c.init(Cipher.ENCRYPT_MODE,key);
        byte[] en=c.doFinal(s.getBytes());
        String encr=Base64.encodeToString(en,Base64.DEFAULT);
        return encr;


    }

    private SecretKeySpec generateKey(String s1)throws Exception {
        final MessageDigest digest= MessageDigest.getInstance("SHA-256");
        byte[] bytes= s1.getBytes("UTF-8");
        digest.update(bytes,0,bytes.length);
        byte[] key=digest.digest();
        SecretKeySpec secretKeySpec= new SecretKeySpec(key,"AES");
        return secretKeySpec;
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

        }
        if(id==R.id.menu_about) {
        }

        return super.onOptionsItemSelected(item);

    }



}
