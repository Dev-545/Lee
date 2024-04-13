package com.example.lee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Soccer extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_soccer);
        getSupportActionBar().setTitle("Soccer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button =findViewById(R.id.a_apply);
        String Activity = "Soccer";
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Soccer.this, Contactform.class);
                intent.putExtra("activity_name", Activity);
                startActivity(intent);
            }
        });

    }
}