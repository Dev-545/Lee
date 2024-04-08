package com.example.lee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    TextInputEditText Name, Phone_number, Mail, Password;
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
        Phone_number = findViewById(R.id.s_phone);
        Mail = findViewById(R.id.s_mail);
        Password = findViewById(R.id.s_pwd);

        Submitbtn = findViewById(R.id.s_signup);
        Loginbtn = findViewById(R.id.s_login);



        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("users");

                String name = Name.getText().toString();
                String phone = Phone_number.getText().toString();
                String mail = Mail.getText().toString();
                String password = Password.getText().toString();

                User_Helper helperClass = new User_Helper(name, phone,mail,password);
                databaseReference.child(phone).setValue(helperClass);

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