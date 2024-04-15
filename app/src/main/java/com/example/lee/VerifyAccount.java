package com.example.lee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lee.databinding.ActivityVerifyAccountBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VerifyAccount extends AppCompatActivity {

    Button verifyBtn;
    EditText phone;

    private Toolbar toolbar;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verify_account);

        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Mobile");

        verifyBtn = findViewById(R.id.verify);
        phone=findViewById(R.id.vphone);

       verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_No = phone.getText().toString();
                if (phone_No.isEmpty() || phone_No.length() <10){
                    Toast.makeText(VerifyAccount.this, "Enter the Correct Phone Number", Toast.LENGTH_SHORT).show();
                }
                else{
                    verifyData(phone_No);
                }
            }
        });



    }

    private void verifyData(String phoneNo) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("users");
        databaseReference.child(phoneNo).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        DataSnapshot dataSnapshot = task.getResult();
                        String Name= String.valueOf(dataSnapshot.child("name").getValue());
                        String Mobile= String.valueOf(dataSnapshot.child("mobile").getValue());
                        String Mail= String.valueOf(dataSnapshot.child("email").getValue());

                        Intent intent = new Intent(VerifyAccount.this, Contact_form.class);
                        String activity_name = getIntent().getExtras().getString("activity_name");
                        intent.putExtra("activity_name",activity_name);
                        intent.putExtra("name",Name);
                        intent.putExtra("mobile", Mobile);
                        intent.putExtra("mail", Mail);
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(VerifyAccount.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(VerifyAccount.this, "Failed To Retrieve Data", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}