package com.example.pattimura.belajarlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pattimura.belajarlogin.Model.User;

public class FormDaftar extends AppCompatActivity implements View.OnClickListener {
    private String user, pass;
    private EditText username, password;
    private Button daftar;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_daftar);

        login = (TextView) findViewById(R.id.txtLogin);
        username = (EditText) findViewById(R.id.edUserDaftar);
        password = (EditText) findViewById(R.id.edPassDaftar);
        daftar = (Button) findViewById(R.id.btnDaftar);

        daftar.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == daftar) {
            user = username.getText().toString();
            pass = password.getText().toString();
            if (!user.equals("") && !pass.equals("")) {
                Intent intent = new Intent(this, FormLogin.class);
                intent.putExtra("username", user);
                intent.putExtra("password", pass);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Tolong isi username dan password anda !", Toast.LENGTH_SHORT).show();
                return;
            }
        } else if (v == login) {
            Intent intent = new Intent(this, FormLogin.class);
            startActivity(intent);
            finish();
        }
    }
}
