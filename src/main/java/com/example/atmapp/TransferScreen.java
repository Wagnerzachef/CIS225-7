package com.example.atmapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class TransferScreen extends AppCompatActivity {

    private Button goBackT;
    private TextView amountT;
    private RadioGroup accountFrom, accountTo;
    private String accountTypeT, accountTypeT2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_screen);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        goBackT = findViewById(R.id.button);
        amountT = findViewById(R.id.Transfernumber);
        accountFrom = findViewById(R.id.from_radio);
        accountTo = findViewById(R.id.to_radio);


        accountFrom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.FromCheck) {
                    Toast.makeText(getApplicationContext(), "Checking", Toast.LENGTH_LONG).show();
                    accountTypeT = "TChecking";
                } else if (i == R.id.FromSave) {
                    Toast.makeText(getApplicationContext(), "Savings", Toast.LENGTH_LONG).show();
                    accountTypeT = "TSavings";
                } else {
                    accountTypeT = "TNone";
                }
            }
        });
        accountTo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.ToCheck) {
                    Toast.makeText(getApplicationContext(), "Checking", Toast.LENGTH_LONG).show();
                    accountTypeT2 = "T2Checking";
                } else if (i == R.id.ToSave) {
                    Toast.makeText(getApplicationContext(), "Savings", Toast.LENGTH_LONG).show();
                    accountTypeT2 = "T2Savings";
                } else {
                    accountTypeT2 = "T2None";
                }
            }
        });

        goBackT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getAmountT = amountT.getText().toString();
                String getAccountT = accountTypeT;
                String getAccount2 = accountTypeT2;
                if (getAmountT == null || getAmountT.isEmpty() || getAmountT.isBlank() || !radioCheck()) {
                    Intent intent = new Intent();
                    setResult(Activity.RESULT_CANCELED, intent);
                    finish();
                } else {
                    Intent intentT = new Intent();
                    intentT.putExtra("amountT", getAmountT);
                    intentT.putExtra("accountT", getAccountT);
                    intentT.putExtra("accountT2", getAccount2);
                    setResult(Activity.RESULT_OK, intentT);
                    finish();
                }

            }
        });
    }
    protected boolean radioCheck() {
        if(accountFrom.getCheckedRadioButtonId() == -1 || accountTo.getCheckedRadioButtonId() == -1) {
            return false;
        } else {
            return true;
        }
    }
}