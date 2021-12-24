package com.example.modullsatu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    String var_nama, var_emailaddress, var_username;
    EditText email, user, nama;
    RadioButton male,female;
    SeekBar seekbar;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11;
    private TextView txtAngka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Registration");
        setupSeekBar();
        Button submitButton = (Button) findViewById(R.id.btnRegister);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        EditText user = (EditText) findViewById(R.id.inputUsername);
        EditText email = (EditText) findViewById(R.id.inputEmail);
        EditText nama = (EditText) findViewById(R.id.inputNama);
        RadioGroup radioGroupGenders = (RadioGroup) findViewById(R.id.radioGrup);
        RadioButton radioButtonChosen = (RadioButton) findViewById(radioGroupGenders.getCheckedRadioButtonId());
        TextView textViewAgeValue = (TextView) findViewById(R.id.txtAngka);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Confirm Data");

        AlertDialog.Builder builder = dialogBuilder.setMessage("Apakah anda sudah yakin dengan data berikut?\n\n" +
                "Username: " + user.getText() + "\n" +
                "Email : " + email.getText() + "\n" +
                "Nama: " + nama.getText() + "\n" +
                "Age: " + textViewAgeValue.getText() + "\n" +
                "Gender: " + radioButtonChosen.getText() + "\n" +
                "Group: " + getCheckBoxValue() + "\n")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        var_username = user.getText().toString();
                        var_emailaddress = email.getText().toString();
                        var_nama= nama.getText().toString();

                        //Intent modul 2
                        Intent i = null;
                        i = new Intent(MainActivity.this, HasilRegis.class);
                        Bundle b = new Bundle();
                        b.putString("user", user.getText().toString());
                        b.putString("email", email.getText().toString());
                        b.putString("nama", nama.getText().toString());
                        b.putString("age", txtAngka.getText().toString());
                        b.putString("gender", radioButtonChosen.getText().toString());
                        b.putString("group", getCheckBoxValue());

                        int id_pilihan = radioGroupGenders.getCheckedRadioButtonId();

                        //Mendapatkan objek radio_pilihan menggunakan id
                        RadioButton gender_pilihan = (RadioButton) findViewById(id_pilihan);

                        Intent intent = i.putExtras(b);
                        startActivity(i);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        DialogInterface dialogInterface = null;
                        dialogInterface.cancel();
                    }

                })
                .setCancelable(true);
        AlertDialog confirmDialog = dialogBuilder.create();
        confirmDialog.show();

    }
    private String getCheckBoxValue() {
        CheckBox cb1 = (CheckBox) findViewById(R.id.cb1);
        CheckBox cb2 = (CheckBox) findViewById(R.id.cb2);
        CheckBox cb3 =(CheckBox) findViewById(R.id.cb3);
        CheckBox cb4 = (CheckBox) findViewById(R.id.cb4);
        CheckBox cb5 = (CheckBox) findViewById(R.id.cb5);
        CheckBox cb6=(CheckBox) findViewById(R.id.cb6);
        CheckBox cb7 = (CheckBox) findViewById(R.id.cb7);
        CheckBox cb8 = (CheckBox) findViewById(R.id.cb8);
        CheckBox cb9 =(CheckBox) findViewById(R.id.cb9);
        CheckBox cb10 = (CheckBox) findViewById(R.id.cb10);
        CheckBox cb11 = (CheckBox) findViewById(R.id.cb11);


        String checkedValue = "";

        if (cb1.isChecked()) {
            checkedValue += cb1.getText() + "" + ",";
        }
        if (cb2.isChecked()) {
            checkedValue += cb2.getText() + "" + ",";
        }
        if (cb3.isChecked()) {
            checkedValue += cb3.getText() + "" + ",";
        }
        if (cb4.isChecked()) {
            checkedValue += cb4.getText() + "" + ",";
        }
        if (cb5.isChecked()) {
            checkedValue += cb5.getText() + "" + ",";
        }
        if (cb6.isChecked()) {
            checkedValue += cb6.getText() + "" + ",";
        }
        if (cb7.isChecked()) {
            checkedValue += cb7.getText() + "" + ",";
        }
        if (cb8.isChecked()) {
            checkedValue += cb8.getText() + "" + ",";
        }
        if (cb9.isChecked()) {
            checkedValue += cb9.getText() + "" + ",";
        }
        if (cb10.isChecked()) {
            checkedValue += cb10.getText() + "" + ",";
        }
        if (cb11.isChecked()) {
            checkedValue += cb11.getText() + "";
        }
        return checkedValue;
    }

    private void setupSeekBar() {
        int MIN = 10;
        int MAX = 60;
        int STEP = 1;

        SeekBar sb1 = (SeekBar) findViewById(R.id.seekBar);
        TextView textViewAgeValue = (TextView) findViewById(R.id.txtAngka);

        sb1.setMax((MAX - MIN) / STEP);

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float computeProgress = (MIN + ( progress * STEP )) * 1f;
                textViewAgeValue.setText(String.format("%.1f th", computeProgress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}