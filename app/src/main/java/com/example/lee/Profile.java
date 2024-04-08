package com.example.lee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    TextView profileName, profileEmail, profileMobileno, profilePassword;
    TextView titleName, titleMobile;
    Button editProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profileMobileno = findViewById(R.id.profileMobile);
        profilePassword = findViewById(R.id.profilePassword);
        titleName = findViewById(R.id.titleName);
        titleMobile = findViewById(R.id.titleMobile);
        editProfile = findViewById(R.id.editButton);

        showAllUserData();

        editProfile.setOnClickListener(view -> passUserData());


    }

    public void showAllUserData(){
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("name");
        String mailUser = intent.getStringExtra("mail");
        String mobileUser = intent.getStringExtra("mobile");
        String passwordUser = intent.getStringExtra("password");

        titleName.setText(nameUser);
        titleMobile.setText(mobileUser);
        profileName.setText(nameUser);
        profileEmail.setText(mailUser);
        profileMobileno.setText(mobileUser);
        profilePassword.setText(passwordUser);
    }

    public void passUserData(){
        String userUsermobile = profileMobileno.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("mobile").equalTo(userUsermobile);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    String nameFromDB = snapshot.child(userUsermobile).child("name").getValue(String.class);
                    String mailFromDB = snapshot.child(userUsermobile).child("email").getValue(String.class);
                    String usermobileFromDB = snapshot.child(userUsermobile).child("mobile").getValue(String.class);
                    String passwordFromDB = snapshot.child(userUsermobile).child("password").getValue(String.class);

                    Intent intent = new Intent(Profile.this,Edit.class);

                    intent.putExtra("name", nameFromDB);
                    intent.putExtra("email", mailFromDB);
                    intent.putExtra("mobile", usermobileFromDB);
                    intent.putExtra("password", passwordFromDB);

                    startActivity(intent);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}