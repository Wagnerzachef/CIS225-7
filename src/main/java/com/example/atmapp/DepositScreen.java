package com.example.atmapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import static android.text.TextUtils.isEmpty;

public class DepositScreen extends AppCompatActivity {
    private Button goBack;
    private TextView amount;
    private RadioGroup account;
    private String accountType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_screen);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        goBack = findViewById(R.id.confirm_button);
        amount = findViewById(R.id.balance_change);
        account = findViewById(R.id.radioGroup);


        account.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.checking_button) {
                    Toast.makeText(getApplicationContext(), "Checking", Toast.LENGTH_LONG).show();
                    accountType = "Checking";
                } else if (i == R.id.savings_button) {
                    Toast.makeText(getApplicationContext(), "Savings", Toast.LENGTH_LONG).show();
                    accountType = "Savings";
                } else {
                    accountType = "None";
                }
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getAmount = amount.getText().toString();
                String getAccount = accountType;
                if(getAmount == null || getAmount.isEmpty() || getAmount.isBlank() || !radioCheck()) {
                    Intent intent = new Intent();
                    setResult(Activity.RESULT_CANCELED, intent);
                    finish();
                }else {
                    Intent intent = new Intent();
                    intent.putExtra("amount", getAmount);
                    intent.putExtra("account", getAccount);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }

            }
        });
    }
    protected boolean radioCheck() {
        if(account.getCheckedRadioButtonId() == -1) {
            return false;
        } else {
            return true;
        }
    }


}