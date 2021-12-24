package com.example.modullsatu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HasilRegis extends AppCompatActivity {

    TextView  HEmail, HUser, HNama, HGender, HAge, HGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_regis);

        HUser = (TextView) findViewById(R.id.hasil_user);
        HEmail = (TextView) findViewById(R.id.hasil_email);
        HNama = (TextView) findViewById(R.id.hasil_nama);
        HAge = (TextView) findViewById(R.id.hasil_age);
        HGender = (TextView) findViewById(R.id.hasil_gender);
        HGroup = (TextView) findViewById(R.id.hasil_group);

        Intent i = getIntent();
        HUser.setText(i.getExtras().getString("user"));
        HEmail.setText(i.getExtras().getString("email"));
        HNama.setText(i.getExtras().getString("nama"));
        HAge.setText(i.getExtras().getString("age"));
        HGender.setText(i.getExtras().getString("gender"));
        HGroup.setText(i.getExtras().getString("group"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Don't go", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Bye-bye", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Go back!", Toast.LENGTH_SHORT).show();
    }
}