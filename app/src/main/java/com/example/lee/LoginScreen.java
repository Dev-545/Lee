package com.example.lee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginScreen extends AppCompatActivity {

    TextInputEditText Phone_number,loginPassword;
    TextView Error;
    Button SignIn, Submitbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        Phone_number = findViewById(R.id.l_mobile);
        loginPassword = findViewById(R.id.l_passwd);
        Submitbtn = findViewById(R.id.btn_submit);
        SignIn = findViewById(R.id.l_signin);
        Error =findViewById(R.id.error_msg);
        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsermobile() | !validatePassword()) {

                } else {
                    checkUser();
                }
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this, SignupScreen.class);
                startActivity(intent);
            }
        });

    }

    public Boolean validateUsermobile() {
        String val = Phone_number.getText().toString();
        if (val.isEmpty()) {
            Phone_number.setError("Phone_number cannot be empty");
            return false;
        } else {
            Phone_number.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String val = loginPassword.getText().toString();
        if (val.isEmpty()) {
            loginPassword.setError("Password cannot be empty");
            Error.setVisibility(View.VISIBLE);
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }


    public void checkUser(){
        String userUsermobile = Phone_number.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("mobile").equalTo(userUsermobile);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    Phone_number.setError(null);
                    String passwordFromDB = snapshot.child(userUsermobile).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userPassword)) {
                        Phone_number.setError(null);

                        String nameFromDB = snapshot.child(userUsermobile).child("name").getValue(String.class);
                        String mailFromDB = snapshot.child(userUsermobile).child("email").getValue(String.class);
                        String mobileFromDB = snapshot.child(userUsermobile).child("mobile").getValue(String.class);
                        Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("mail", mailFromDB);
                        intent.putExtra("mobile", mobileFromDB);
                        intent.putExtra("password", passwordFromDB);

                        startActivity(intent);
                    } else {
                        loginPassword.setError("Invalid Credentials");
                        loginPassword.requestFocus();
                    }
                } else {
                    Phone_number.setError("User does not exist");
                    Phone_number.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}