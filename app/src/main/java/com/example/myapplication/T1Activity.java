package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.module.User;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class T1Activity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener, View.OnClickListener{

    EditText editTextN,editTextD,editTextP,editTextE;
    RadioGroup radioGroup;
    Spinner spinner;
    Button buttonSubmit,buttonView;
    String name,gender,dob,country,phone,email;
    String[] countries = {"Nepal","India","Srilanka","Bhutan","Maldives",
            "Myanmar","Pakistan","Afganistan"};

    List<User> userList = new ArrayList<>();

    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener mydatepicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            calendar.set(Calendar.YEAR,i);
            calendar.set(Calendar.MONTH,i1);
            calendar.set(Calendar.DAY_OF_MONTH,i2);
            String mydateFormat = "dd-MM-y";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(mydateFormat,
                    Locale.getDefault());
            editTextD.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t1);

        editTextN = findViewById(R.id.etName);
        editTextD = findViewById(R.id.etDob);
        editTextP = findViewById(R.id.etPhone);
        editTextE = findViewById(R.id.etEmail);
        radioGroup = findViewById(R.id.rgGender);
        spinner = findViewById(R.id.spCountry);
        buttonSubmit = findViewById(R.id.btnSubmit);
        buttonView = findViewById(R.id.btnView);

        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.spinner_values,countries);
        spinner.setAdapter(adapter);

        radioGroup.setOnCheckedChangeListener(this);
        setSpinnerValue();
        buttonSubmit.setOnClickListener(this);
        editTextD.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.rbMale){
            gender = "Male";
        }
        if (i == R.id.rbFemale){
            gender = "Female";
        }
        if (i == R.id.rbOthers){
            gender = "Other";
        }
    }

    private void setSpinnerValue(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                country = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(T1Activity.this, "Please select country",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        name = editTextN.getText().toString();
        dob = editTextD.getText().toString();
        phone = editTextP.getText().toString();
        email = editTextE.getText().toString();

        if(view.getId() == R.id.btnSubmit){
            if(validate()){
                userList.add(new User(name,gender,dob,country,phone,email));
                Toast.makeText(this, "User Added", Toast.LENGTH_SHORT).show();
            }
        }
        //image file with extension
//        String uri = "@drawable/"+img;
//        int resID= getResources().getIdentifier(uri, null, getPackageName());
//        Drawable drawable = getResources().getDrawable(resID);
//        imageView.setImageDrawable(drawable);

        if(view.getId() == R.id.etDob){
            new DatePickerDialog(this,mydatepicker,calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
        }

        if(view.getId() == R.id.btnView){
            Intent intent = new Intent(this,UserListActivity.class);
            intent.putExtra("allusers",(Serializable) userList);
            startActivity(intent);
        }
    }

    private boolean validate(){
        if(TextUtils.isEmpty(name)){
            editTextN.setError("Enter Name");
            editTextN.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(dob)){
            editTextD.setError("Enter DoB");
            editTextD.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(gender)){
            Toast.makeText(this, "Plz select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(country)){
            Toast.makeText(this, "Plz select country", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(phone)){
            editTextP.setError("Enter Phone");
            editTextP.requestFocus();
            return false;
        }
        if (!TextUtils.isDigitsOnly(phone)){
            editTextP.setError("Invalid Phone");
            editTextP.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(email)){
            editTextE.setError("Enter Email");
            editTextE.requestFocus();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextE.setError("Invalid Email");
            editTextE.requestFocus();
            return false;
        }
        return true;
    }
}
