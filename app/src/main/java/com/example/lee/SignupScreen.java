package com.example.lee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupScreen extends AppCompatActivity {
    TextInputEditText Name, Age, Phone_number, Mail, Password;
    String Selected_Activity;
    RadioGroup Gender;
    RadioButton R_Gender;
    Spinner spinner;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button Submitbtn, Loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_screen);

        Name = findViewById(R.id.s_name);
        Age = findViewById(R.id.s_age);
        Gender = findViewById(R.id.radio_gender);
        Phone_number = findViewById(R.id.s_phone);
        Mail = findViewById(R.id.s_mail);
        Password = findViewById(R.id.s_pwd);
        spinner = findViewById(R.id.spinner);
        Submitbtn = findViewById(R.id.s_signup);
        Loginbtn = findViewById(R.id.s_login);

        Gender.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int selectedId = Gender.getCheckedRadioButtonId();
                        R_Gender = (RadioButton) findViewById(selectedId);
                    }
                }
        );

        Activity.initActivity();
        SpinnerAdapter CustomAdapter = new SpinnerAdapter(this, R.layout.custom_spinner, Activity.getActivityList());
        spinner.setAdapter(CustomAdapter);




        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("users");

                String name = Name.getText().toString();
                String age = Age.getText().toString();
                String gender = R_Gender.getText().toString();
                String activity = spinner.toString();
                String phone = Phone_number.getText().toString();
                String mail = Mail.getText().toString();
                String password = Password.getText().toString();

                HelperClass helperClass = new HelperClass(name, age, gender, activity, phone, mail,password);
                databaseReference.child(name).setValue(helperClass);

                Toast.makeText(SignupScreen.this, "You have Sucessfully Signed up", Toast.LENGTH_LONG).show();


                Intent intent = new Intent(SignupScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupScreen.this, LoginScreen.class);
                startActivity(intent);
                finish();
            }
        });



    }
}