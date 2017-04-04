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

import java.util.ArrayList;

public class FormLogin extends AppCompatActivity implements View.OnClickListener {
    private String user, pass;
    private Bundle bundle;
    private EditText username, password;
    private Button masuk;
    private TextView daftar;
    private User pengguna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        bundle = getIntent().getExtras();
        if (bundle != null) {
            user = bundle.getString("username");
            pass = bundle.getString("password");
            pengguna = new User(user, pass);
        }

        daftar = (TextView) findViewById(R.id.txtDaftar);
        username = (EditText) findViewById(R.id.edUser);
        password = (EditText) findViewById(R.id.edPass);
        masuk = (Button) findViewById(R.id.btnMasuk);

        masuk.setOnClickListener(this);
        daftar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == masuk) {
            user = username.getText().toString();
            pass = password.getText().toString();
            if (!user.equals("") && !pass.equals("")) {
                if (pengguna != null) {
                    if (user.equals(pengguna.getUsername()) && pass.equals(pengguna.getPassword())) {
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.putExtra("username", user);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "Username atau password anda salah ", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    Toast.makeText(this, "Silahkan daftarkan diri anda terlebih dahulu !", Toast.LENGTH_SHORT).show();
                    return;
                }
            } else {
                Toast.makeText(this, "Tolong isi username dan password anda !", Toast.LENGTH_SHORT).show();
                return;
            }
        } else if (v == daftar) {
            Intent intent = new Intent(this, FormDaftar.class);
            startActivity(intent);
        }
    }
}
