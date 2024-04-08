package com.example.lee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class SignupScreen extends AppCompatActivity {
    TextInputEditText Name,Mail,Phone_number,Password;
    Button Submitbtn, Loginbtn;

    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_screen);

        Name = findViewById(R.id.l_name);
        Mail = findViewById(R.id.l_mail);
        Phone_number= findViewById(R.id.l_mobile);
        Password = findViewById(R.id.l_passwd);
        Loginbtn = findViewById(R.id.l_login);
        Submitbtn = findViewById(R.id.btn_submit);
        Submitbtn.setOnClickListener(view -> {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("users");
            String name = Name.getText().toString();
            String mail = Mail.getText().toString();
            String mobile =Phone_number.getText().toString();
            String password = Password.getText().toString();
            HelperClass helperClass = new HelperClass(name, mail,mobile, password);
            reference.child(mobile).setValue(helperClass);
            Toast.makeText(SignupScreen.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignupScreen.this, LoginScreen.class);
            startActivity(intent);
        });
        Loginbtn.setOnClickListener(view -> {
            Intent intent = new Intent(SignupScreen.this, LoginScreen.class);
            startActivity(intent);
        });


    }
}



