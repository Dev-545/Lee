package com.example.lee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;



public class LoginScreen extends AppCompatActivity {
    TextInputEditText Phone, Password;
    Button SignIn, Submitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        Phone = findViewById(R.id.l_phone);
        Password = findViewById(R.id.l_passwd);
        SignIn =   findViewById(R.id.l_signin);
        Submitbtn = findViewById(R.id.btn_submit);
        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validatephone() | !validatepwd()){

                }
                else {
                    checkuser();
                }
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, SignupScreen.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public Boolean validatephone(){
        String val = Phone.getText().toString();
        if(val.isEmpty() && val.length()<10){
            Phone.setError("enter Correct Phone Number");
            return false;
        }
        else {
            Phone.setError(null);
            return true;

        }

    }
    public Boolean validatepwd(){
        String val = Password.getText().toString();
        if(val.isEmpty()){
            Password.setError("Password Cannot be Empty");
            return false;
        }
        else if((val.length())<8){
            Password.setError("Password Must be 8 Characters");
            return false;

        }
        else {
            Password.setError(null);
            return true;

        }

    }
    public void checkuser(){
        String phone = Phone.getText().toString().trim();
        String passwd = Password.getText().toString().trim();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");
        Query query = databaseReference.orderByChild("mobile").equalTo(phone);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    Phone.setError(null);
                    String pwdDB =snapshot.child(phone).child("passwd").getValue(String.class);

                    if(pwdDB.equals(passwd)){
                        Phone.setError(null);
                        Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Password.setError("Invalid Password");
                        Password.requestFocus();

                    }
                }
                else{
                    Phone.setError("Records Not Found");
                    Phone.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
}