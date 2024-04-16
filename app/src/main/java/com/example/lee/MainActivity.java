package com.example.lee;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private  Toolbar toolbar;

    CardView cardView;

    Button Cricket, Soccer, Hockey, Throwball, Badminton, VolleyBall;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar= findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

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
                Intent intent = new Intent(MainActivity.this, Activity_Cricket.class);
                startActivity(intent);
                finish();
            }
        });

        Soccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_Soccer.class);
                startActivity(intent);
                finish();
            }
        });

        Hockey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_Hockey.class);
                startActivity(intent);
                finish();
            }
        });

        Throwball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_Throwball.class);
                startActivity(intent);
                finish();
            }
        });

        Badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_Batmiton.class);
                startActivity(intent);
                finish();
            }
        });

        VolleyBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_Volleyball.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                profile();

                break;
            case R.id.logout:
                startActivity( new Intent(MainActivity.this,LoginScreen.class));
                Toast.makeText(getApplicationContext(), "Logout Sucessfully", Toast.LENGTH_LONG).show();
                break;
            case R.id.updation:
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(@NonNull MenuItem item) {
                        showDialog();
                        Toast.makeText(getApplicationContext(), "Whats New", Toast.LENGTH_LONG).show();
                        return true;
                    }
                });

                break;
            case R.id.about:
                startActivity(new Intent(MainActivity.this, AboutScreen.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.popupscreen);
        dialog.show();
        Button close = dialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void profile() {
        String phoneNo = getIntent().getExtras().getString("mobile");
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
                        String passwd = String.valueOf(dataSnapshot.child("password").getValue());

                        Intent intent = new Intent(MainActivity.this, Profile.class);
                        intent.putExtra("name",Name);
                        intent.putExtra("mobile", Mobile);
                        intent.putExtra("mail", Mail);
                        intent.putExtra("password",passwd);
                        startActivity(intent);

                    }
                    else {
                    }

                }

            }


        });

    }
}