package com.example.ex4_simplecalculator;

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

        TimView();

        Cong.setOnClickListener(listeCong);
        Nhan.setOnClickListener(listenNhan);
        Tru.setOnClickListener(listeTru);
        Chia.setOnClickListener(listenChia);
    }
    void TimView() {
        editTextA = (EditText) findViewById(R.id.edtA);
        editTextB = (EditText) findViewById(R.id.edtB);
        editTextKQ = (EditText) findViewById(R.id.edtKQ);
        Cong = (Button) findViewById(R.id.btnCong);
        Nhan = (Button) findViewById(R.id.btnNhan);
        Tru = (Button) findViewById(R.id.btnTru);
        Chia = (Button) findViewById(R.id.btnChia);
    }
    EditText editTextA;
    EditText editTextB;
    EditText editTextKQ;
    Button Cong, Tru, Nhan, Chia;
    //************
    View.OnClickListener listeCong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strEdtA = editTextA.getText().toString();
            String strEdtB = editTextB.getText().toString();

            double soA = Double.parseDouble(strEdtA);
            double soB = Double.parseDouble(strEdtB);

            editTextKQ.setText(String.valueOf(soA + soB));
        }
    };
    View.OnClickListener listeTru = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strEdtA = editTextA.getText().toString();
            String strEdtB = editTextB.getText().toString();

            double soA = Double.parseDouble(strEdtA);
            double soB = Double.parseDouble(strEdtB);

            editTextKQ.setText(String.valueOf(soA - soB));
        }
    };
    View.OnClickListener listenNhan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strEdtA = editTextA.getText().toString();
            String strEdtB = editTextB.getText().toString();

            double soA = Double.parseDouble(strEdtA);
            double soB = Double.parseDouble(strEdtB);

            editTextKQ.setText(String.valueOf(soA * soB));
        }
    };
    View.OnClickListener listenChia = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strEdtA = editTextA.getText().toString();
            String strEdtB = editTextB.getText().toString();

            double soA = Double.parseDouble(strEdtA);
            double soB = Double.parseDouble(strEdtB);

            if(soB == 0)
                editTextKQ.setText("Không thể chia cho 0");
            else
                editTextKQ.setText(String.valueOf(soA / soB));
        }
    };
    //************
}