package com.example.ex4_simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextA;
    EditText editTextB;
    EditText editTextKQ;
    int soA;
    int soB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextA = findViewById(R.id.edtA);
        editTextB = findViewById(R.id.edtB);
        editTextKQ = findViewById(R.id.edtKQ);
    }
    public void Cong(View v) {
        int soA = Integer.parseInt(editTextA.getText().toString());
        int soB = Integer.parseInt(editTextB.getText().toString());
        editTextKQ.setText(String.valueOf(soA + soB));
    }
    public void Tru(View v) {
        int soA = Integer.parseInt(editTextA.getText().toString());
        int soB = Integer.parseInt(editTextB.getText().toString());
        editTextKQ.setText(String.valueOf(soA - soB));
    }
    public void Nhan(View v) {
        int soA = Integer.parseInt(editTextA.getText().toString());
        int soB = Integer.parseInt(editTextB.getText().toString());
        editTextKQ.setText(String.valueOf(soA * soB));
    }
    public void Chia(View v) {
        int soA = Integer.parseInt(editTextA.getText().toString());
        int soB = Integer.parseInt(editTextB.getText().toString());
        if(soB == 0)
            editTextKQ.setText("Không thể chia cho 0");
        else
            editTextKQ.setText(String.valueOf(soA / soB));
    }
}