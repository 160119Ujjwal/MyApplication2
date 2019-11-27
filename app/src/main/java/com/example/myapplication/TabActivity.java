package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayout = findViewById(R.id.myTab);
        viewPager = findViewById(R.id.myvPager);

        FragmentManager fm = getSupportFragmentManager();
        MyvpAdapter adapter = new MyvpAdapter(fm);

        adapter.addFragments(new BlankFragment(),"First");
        adapter.addFragments(new SecondFragment(),"Second");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
