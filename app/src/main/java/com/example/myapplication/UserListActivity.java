package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.module.User;

import java.util.List;

public class UserListActivity extends AppCompatActivity {

    ListView listView;

    String[] test = {"a","b","c"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        listView = findViewById(R.id.lvUsers);
        Intent intent = getIntent();
        final List<User> userList = (List<User>) intent.getSerializableExtra("allusers");
        String[] userNames = new String[userList.size()];

        int i=0;
        for (User user:userList){
            userNames[i] = user.getName();
            i++;
        }

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.spinner_values,userNames);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent1 = new Intent(UserListActivity.this,UserDetailActivity.class);
                intent1.putExtra("Name",userList.get(i).getName());
                intent1.putExtra("Gender",userList.get(i).getGender());
                intent1.putExtra("DoB",userList.get(i).getDob());
                intent1.putExtra("Country",userList.get(i).getCountry());
                intent1.putExtra("Email",userList.get(i).getEmail());
                intent1.putExtra("Phone",userList.get(i).getPhone());
                startActivity(intent1);

            }
        });

    }
}
