package com.pchailam.ex12_intent_vd2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private TextView tvNameW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnQuizz = findViewById(R.id.quiz);

        tvNameW = findViewById(R.id.nameW);
        tvNameW.setText(getIntent().getStringExtra("T"));

        btnQuizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toQuizz(v);
            }
        });
    }
    public void toQuizz(View view) {
        Intent next =  new Intent(this, QuizzActivity.class);
        startActivity(next);
    }
}