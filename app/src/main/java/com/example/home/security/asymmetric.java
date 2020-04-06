package com.example.home.security;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigInteger;
import java.util.Map;

public class asymmetric extends AppCompatActivity {
EditText ae1,ae2;
Button ab1,ab2;
private String publicKey = "";
private String privateKey ="";
private byte[] encodeData= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asymmetric);
        ae1=(EditText)findViewById(R.id.ae1);
        ae2=(EditText) findViewById(R.id.ae2);
        ab1=(Button) findViewById(R.id.ab1);
        ab2=(Button)findViewById(R.id.ab2);

       try {
           Map<String, Object> keyMap = rsa.initKey();
           publicKey =rsa.getPublicKey(keyMap);
           privateKey =rsa.getPrivateKey(keyMap);
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }
    public void encrypt(View v)
    {
        String publicKey = getPublicKey();

        byte[] rsaData =ae1.getText().toString().getBytes();
    try{    encodeData =rsa.encryptByPublicKey(rsaData,getPublicKey());
        String encodeStr = new BigInteger(1,encodeData).toString();
    ae2.setText(encodeStr);
    }
    catch(Exception e)
    {e.printStackTrace();}

    }
    public void descrypt(View v)
    {


        try {
            byte[] decode = rsa.encryptByPrivateKey(encodeData, getPrivateKey());
            String decodeStr = new String(decode);
            ae2.setText(decodeStr);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }




    }
    public String getPublicKey()
    {
        return publicKey;
    }
    public String getPrivateKey()
    {
        return privateKey;
    }






}





