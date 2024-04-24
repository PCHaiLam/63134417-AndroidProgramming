package com.pchailam.ex11_intent_vd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);
        Button btn = findViewById(R.id.btn2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChuyenManHinh(v);
            }
        });
    }
    public void ChuyenManHinh(View v){
        Intent next = new Intent(this, MainActivity.class);
        startActivity(next);
    }
}