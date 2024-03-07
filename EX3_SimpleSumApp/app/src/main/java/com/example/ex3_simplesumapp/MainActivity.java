package com.example.ex3_simplesumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void XuLyCong(View view) {
        EditText editTextA = findViewById(R.id.edtA);
        EditText editTextB = findViewById(R.id.edtB);
        EditText editTextKQ = findViewById(R.id.edtKQ);

        int soA = Integer.parseInt(editTextA.getText().toString());
        int soB = Integer.parseInt(editTextB.getText().toString());

        editTextKQ.setText(String.valueOf(soA + soB));
    }
}