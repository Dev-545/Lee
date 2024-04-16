package com.example.lee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class AboutScreen extends AppCompatActivity {

    Button b_mailbtn,b_gitbtn,b_linkeinbtn, v_mailbtn,v_gitbtn,v_linkeinbtn;
    ProgressBar b_Python, b_Java,b_Android_studio,b_Flutter,b_React,v_Python, v_Java,v_Android_studio,v_Dbms,v_Fullstack;
    ImageButton b_imageButton,v_imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_screen);

        b_mailbtn =findViewById(R.id.navmail_bk);
        b_gitbtn = findViewById(R.id.navgit_bk);
        b_linkeinbtn = findViewById(R.id.navlink_bk);

        v_mailbtn =findViewById(R.id.navmail_vino);
        v_gitbtn = findViewById(R.id.navgit_vino);
        v_linkeinbtn = findViewById(R.id.navlink_vino);

        b_Python =findViewById(R.id.b_pythonbar);
        b_Java =findViewById(R.id.b_javabar);
        b_Android_studio =findViewById(R.id.b_androbar);
        b_Flutter =findViewById(R.id.b_flutterbar);
        b_React = findViewById(R.id.b_reactbar);

        v_Python =findViewById(R.id.v_pythonbar);
        v_Java =findViewById(R.id.v_javabar);
        v_Android_studio =findViewById(R.id.v_androbar);
        v_Dbms =findViewById(R.id.v_dbmsbar);
        v_Fullstack = findViewById(R.id.v_fullstackbar);

        b_imageButton = findViewById(R.id.navproj_bk);

        v_imageButton = findViewById(R.id.navproj_vino);

//        Balaji Kumar
        b_mailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto"));
                String recipent = "kumarbalaji545@gmail.com";
                intent.putExtra(Intent.EXTRA_EMAIL,recipent);
                intent.setType("text/plain");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent,"send mail"));

            }
        });

        b_gitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Dev-545/")));

            }
        });
        b_linkeinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/balaji-kumar-b16487221/")));
            }
        });
        int Python_bk = 75;
        b_Python.setProgress(Python_bk);

        int Java_bk = 60;
        b_Java.setProgress(Java_bk);

        int Android_studio_bk = 80;
        b_Android_studio.setProgress(Android_studio_bk);

        int Flutter_bk = 50;
        b_Flutter.setProgress(Flutter_bk);

        int React_bk = 60;
        b_React.setProgress(React_bk);

        b_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri =Uri.parse("https://vlab.mebot.in/projects/E-commerce-capstone/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

//        Vinoth
        v_mailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto"));
                String recipent = "vinothdhakshana1206@gmail.com";
                intent.putExtra(Intent.EXTRA_EMAIL,recipent);
                intent.setType("text/plain");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent,"send mail"));

            }
        });

        v_gitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/vinolee-1206")));

            }
        });
        v_linkeinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/vinoth-d-6514352a3/")));
            }
        });



        int Python_vino = 80;
        v_Python.setProgress(Python_vino);

        int Java_vino = 60;
        v_Java.setProgress(Java_vino);

        int Android_studio_vino = 90;
        v_Android_studio.setProgress(Android_studio_vino);

        int Dbms_vino = 70;
        v_Dbms.setProgress(Dbms_vino);

        int Fullstack_vino = 70;
        v_Fullstack.setProgress(Fullstack_vino);


        v_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri =Uri.parse("https://vlab.mebot.in/projects/Startup-capstone/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });



    }
}