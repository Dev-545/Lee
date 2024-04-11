package com.example.lee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CardView cardView;
    Button Cricket, Soccer, Hockey, Throwball, Badminton, VolleyBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cardView = findViewById(R.id.c);
        Cricket = findViewById(R.id.nav_cricket);
        Soccer = findViewById(R.id.nav_soccer);
        Hockey = findViewById(R.id.nav_hockey);
        Throwball = findViewById(R.id.nav_throwball);
        Badminton = findViewById(R.id.nav_badminton);
        VolleyBall = findViewById(R.id.nav_volleyball);

        cardView.setPreventCornerOverlap(false);

        Cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cricket.class);
                startActivity(intent);
                finish();
            }
        });

        Soccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Soccer.class);
                startActivity(intent);
                finish();
            }
        });

        Hockey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Hockey.class);
                startActivity(intent);
                finish();
            }
        });

        Throwball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Throwball.class);
                startActivity(intent);
                finish();
            }
        });

        Badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Batmiton.class);
                startActivity(intent);
                finish();
            }
        });

        VolleyBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Volleyball.class);
                startActivity(intent);
                finish();
            }
        });

    }
}