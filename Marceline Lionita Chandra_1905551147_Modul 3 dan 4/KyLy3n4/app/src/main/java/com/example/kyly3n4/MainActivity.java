package com.example.kyly3n4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {
    static int grup =0;
    Button button_register;
    EditText username, name, email;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11;
    RadioGroup radioGroup;
    RadioButton gender;
    SeekBar seekbar_age;
    TextView age;
    String keterangan;
    String is_valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper db = new DBHelper(this);

        keterangan = " ";
        is_valid = "0";
        username = findViewById(R.id.inputUsername);
        name = findViewById(R.id.inputNama);
        email = findViewById(R.id.inputEmail);
        button_register = findViewById(R.id.btnRegister);
        radioGroup = findViewById(R.id.radioGrup);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);
        cb6 = findViewById(R.id.cb6);
        cb7 = findViewById(R.id.cb7);
        cb8 = findViewById(R.id.cb8);
        cb9 = findViewById(R.id.cb9);
        cb10 = findViewById(R.id.cb10);
        cb11 = findViewById(R.id.cb11);
        seekbar_age = findViewById(R.id.seekBar);
        age = findViewById(R.id.txtAngka);
        seekbar_age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age.setText (progress + ("th"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected_gender = radioGroup.getCheckedRadioButtonId();
                gender = findViewById(selected_gender);

                String grup = "";
                if(cb1.isChecked() && cb2.isChecked()){
                    grup += "BTS, Red Velvet";
                }
                else{
                    if(cb1.isChecked()) {
                        grup += "BTS";
                    }
                    if(cb2.isChecked()) {
                        grup += "Red Velvet";
                    }
                    if(cb3.isChecked()) {
                        grup += "NCT";
                    }
                    if(cb4.isChecked()) {
                        grup += "BlackPink";
                    }
                    if(cb5.isChecked()) {
                        grup += "EXO";
                    }
                    if(cb6.isChecked()) {
                        grup += "Twice";
                    }
                    if(cb7.isChecked()) {
                        grup += "aespa";
                    }
                    if(cb8.isChecked()) {
                        grup += "Stray Kids";
                    }
                    if(cb9.isChecked()) {
                        grup += "Weeekly";
                    }
                    if(cb10.isChecked()) {
                        grup += "Victon";
                    }
                    if(cb11.isChecked()) {
                        grup  += "Others";
                    }
                }

                String txt_username =  username.getText().toString();
                String txt_name =  name.getText().toString();
                String txt_email =  email.getText().toString();
                String txt_gender = gender.getText().toString();
                String txt_grup = grup;
                String txt_age = String.valueOf(seekbar_age.getProgress());

                Boolean checkinsert = db.insert(txt_username, txt_name, txt_email, txt_gender, txt_grup, txt_age, " ", "0");
                if(checkinsert ==true){
                    Toast.makeText(MainActivity.this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Pendaftaran gagal", Toast.LENGTH_SHORT).show();
                }

                username.setText(null);
                name.setText(null);
                email.setText(null);
                radioGroup.clearCheck();
                cb1.setChecked(false);
                cb2.setChecked(false);
                cb3.setChecked(false);
                cb4.setChecked(false);
                cb5.setChecked(false);
                cb6.setChecked(false);
                cb7.setChecked(false);
                cb8.setChecked(false);
                cb9.setChecked(false);
                cb10.setChecked(false);
                cb11.setChecked(false);
                seekbar_age.setProgress(0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.data){
            startActivity(new Intent(this, Data.class));
        } else if (item.getItemId() == R.id.logout) {
            //startActivity(new Intent(this, SettingActivity.class));
        }
        return true;
    }

}