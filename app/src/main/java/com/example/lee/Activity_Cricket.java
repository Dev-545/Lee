package com.example.lee;

import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Activity_Cricket extends AppCompatActivity {
    private Toolbar toolbar;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cricket);

        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("cricket");

        button =findViewById(R.id.a_apply);
        String Activity = "Cricket";
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Cricket.this, VerifyAccount.class);
                intent.putExtra("activity_name", Activity);
                startActivity(intent);
            }
        });

    }
}