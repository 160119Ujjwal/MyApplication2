package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class R1Activity extends AppCompatActivity implements View.OnClickListener {

    int clickCount;
    Button btnClick;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r1);

        btnClick = findViewById(R.id.btnClick);
        imageView1 = findViewById(R.id.ivImage1);
        imageView2 = findViewById(R.id.ivImage2);
        imageView3 = findViewById(R.id.ivImage3);
        imageView4 = findViewById(R.id.ivImage4);
        imageView5 = findViewById(R.id.ivImage5);
        imageView6 = findViewById(R.id.ivImage6);
        imageView7 = findViewById(R.id.ivImage7);
        imageView8 = findViewById(R.id.ivImage8);
        imageView9 = findViewById(R.id.ivImage9);

        btnClick.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        clickCount = clickCount + 1;
        switch (clickCount) {
            case 1:
                imageView9.setVisibility(View.INVISIBLE);
                imageView1.setVisibility(View.VISIBLE);
                break;
            case 2:
                imageView1.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.VISIBLE);
                break;
            case 3:
                imageView2.setVisibility(View.INVISIBLE);
                imageView3.setVisibility(View.VISIBLE);
                break;
            case 4:
                imageView3.setVisibility(View.INVISIBLE);
                imageView4.setVisibility(View.VISIBLE);
                break;
            case 5:
                imageView4.setVisibility(View.INVISIBLE);
                imageView5.setVisibility(View.VISIBLE);
                break;
            case 6:
                imageView5.setVisibility(View.INVISIBLE);
                imageView6.setVisibility(View.VISIBLE);
                break;
            case 7:
                imageView6.setVisibility(View.INVISIBLE);
                imageView7.setVisibility(View.VISIBLE);
                break;
            case 8:
                imageView7.setVisibility(View.INVISIBLE);
                imageView8.setVisibility(View.VISIBLE);
                break;
            case 9:
                imageView8.setVisibility(View.INVISIBLE);
                imageView9.setVisibility(View.VISIBLE);
                break;
            case 10:
                imageView9.setVisibility(View.INVISIBLE);
                imageView1.setVisibility(View.VISIBLE);
                clickCount = 1;
        }
    }
}
