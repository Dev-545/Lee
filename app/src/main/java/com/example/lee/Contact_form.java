package com.example.lee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Contact_form extends AppCompatActivity {
    RadioGroup Gender;
    RadioButton R_Gender;
    TextInputEditText Name, Age, Mobile, Mail, Address, Activity;
    Button Submitbtn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);

        Name = findViewById(R.id.l_name);
        Age = findViewById(R.id.c_age);
        Gender = findViewById(R.id.radio_gender);
        Mobile = findViewById(R.id.l_mobile);
        Mail = findViewById(R.id.l_mail);
        Address = findViewById(R.id.c_address);
        Activity = findViewById(R.id.c_activity);
        Gender = findViewById(R.id.radio_gender);
        Gender.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int selectedId = Gender.getCheckedRadioButtonId();
                        R_Gender = (RadioButton) findViewById(selectedId);
                    }
                }
        );

        Submitbtn = findViewById(R.id.c_submit);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String mobile = intent.getStringExtra("mobile");
        String email = intent.getStringExtra("email");
        String activity = intent.getStringExtra("activity_name");

        Name.setText(name);
        Mobile.setText(mobile);
        Mail.setText(email);
        Activity.setText(activity);



        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("contacts");

                String name = Name.getText().toString().trim();
                String age = Age.getText().toString().trim();
                String mobile = Mobile.getText().toString().trim();
                String mail = Mail.getText().toString().trim();
                String address = Address.getText().toString().trim();
                String activity = Activity.getText().toString().trim();
                String gender = ((RadioButton) findViewById(Gender.getCheckedRadioButtonId())).getText().toString();

                Activity_Helper contact = new Activity_Helper (name, age, mobile, mail, address, activity,gender);
                databaseReference.push().setValue(contact);

                Toast.makeText(Contact_form.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Contact_form.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
