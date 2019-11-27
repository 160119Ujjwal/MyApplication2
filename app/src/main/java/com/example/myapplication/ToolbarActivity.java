package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.my_menu,menu);//passing parameter
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // return super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.menuOrder) {
            Toast.makeText(this, "Menu Outer", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.menuFirst) {
            Toast.makeText(this, "First", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.menuSecond) {
            Toast.makeText(this, "Second", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.sub1) {
            Toast.makeText(this, "Sub Menu 1", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.sub2) {
            Toast.makeText(this, "Sub Menu 2", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    }

