package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SharedPreActivity extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pre);
        sp =getApplicationContext().getSharedPreferences("mysp",MODE_PRIVATE);
       /* editor=sp.edit();
        editor.putString("name","ujjwal");
        editor.putInt("age",22);
        editor.putBoolean("isMember",true);
        editor.commit();*/
       String n=sp.getString("name","");
       int a=sp.getInt("age",0);
       boolean im=sp.getBoolean("isMember",false);
       int b=sp.getInt("zip",0);

        Toast.makeText(this,"Name: "+n+"\n"
        +"Age: "+a+"\n"
        + "Member: "+im+"\n"
        +"Zip: "+b, Toast.LENGTH_SHORT).show();
    }
}
