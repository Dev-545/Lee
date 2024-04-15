package com.example.lee;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutScreen extends AppCompatActivity {
    ProgressBar b_Python, b_Java,b_Android_studio,b_Flutter,b_React;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_screen);
        b_Python =findViewById(R.id.pythonbar);
//        b_Java =findViewById(R.id.pythonbar);
//        b_Android_studio =findViewById(R.id.pythonbar);
//        b_Flutter =findViewById(R.id.pythonbar);
//        b_React = findViewById(R.id.pythonbar)

        int Python = 75;
        b_Python.setProgress(Python);



    }
}