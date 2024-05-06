package com.pchailam.ex12_intent_vd2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(v);
            }
        });
    }
    private void Login(View v) {
        EditText edtUserName = findViewById(R.id.edtUsername);
        EditText edtPass = findViewById(R.id.edtPassword);
        TextView tvNotify = findViewById(R.id.notify);

        String userName = edtUserName.getText().toString();
        String passWord = edtPass.getText().toString();

        if(userName.equals("phanchauhailam") && passWord.equals("lam15082003")) {
            Intent Home =  new Intent(this, HomeActivity.class);
            Home.putExtra("T", userName);
            startActivity(Home);
        }
        else {
            tvNotify.setText("Sai thông tin đăng nhập!!!");
        }
    }
}