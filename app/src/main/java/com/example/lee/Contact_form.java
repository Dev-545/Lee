package com.example.lee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import com.google.firebase.database.DataSnapshot;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Contact_form extends AppCompatActivity {

    RadioGroup Gender;
    RadioButton R_Gender;
    TextInputEditText Name, Age, Activity, Phone, Mail;

    DatabaseReference databaseReference;

    Button Submitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact_form);

        Name = findViewById(R.id.c_name);
        Age = findViewById(R.id.c_age);
        Gender = findViewById(R.id.radio_gender);
        Submitbtn = findViewById(R.id.c_submit);
        Gender.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int selectedId = Gender.getCheckedRadioButtonId();
                        R_Gender = (RadioButton) findViewById(selectedId);

                    }
                }
        );
        Phone = findViewById(R.id.c_phone);
        Mail = findViewById(R.id.c_mail);


        Activity = findViewById(R.id.c_activity);
        Intent intent = getIntent();
        String str = intent.getStringExtra("activity_name");
        String nameUser = intent.getStringExtra("name");
        String emailUser = intent.getStringExtra("mail");
        String mobileUser = intent.getStringExtra("mobile");

        Name.setText(nameUser);
        Mail.setText(emailUser);
        Phone.setText(mobileUser);
        Activity.setText(str);
        String name= Name.getText().toString();
        String mail= Mail.getText().toString();
        String age= Age.getText().toString();
        String phone= Phone.getText().toString();
        String gender= Gender.toString();
        String activity= Activity.getText().toString();

        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference= FirebaseDatabase.getInstance().getReference("Activity");
                Activity_Helper helperClass = new Activity_Helper(name,age,gender,activity,mail,phone);
                databaseReference.child(phone).setValue(helperClass);

                Toast.makeText(getApplicationContext(),
                        "Data Saved Sucessfully",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Contact_form.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });







    }
}