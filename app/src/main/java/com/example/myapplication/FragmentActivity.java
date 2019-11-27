package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentActivity extends AppCompatActivity {

    Button button1;
   // Button button2;
    Boolean check = true;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_);

        button1 = findViewById(R.id.btnFirstFrag);
        //button2 = findViewById(R.id.btnSecondFrag);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check){
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragHolder, new BlankFragment());
                    ft.commit();
                    check = false;
                    button1.setText("Load Second");
                }
               else{
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragHolder, new SecondFragment());
                    ft.commit();
                    check = true;
                    button1.setText("Load First");
                }
            }
        });

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.fragHolder, new SecondFragment());
//                ft.commit();
//            }
//        });
    }

}
