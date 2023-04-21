package com.example.atmapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class WithdrawActivity extends AppCompatActivity {
        private Button goBackW;
        private TextView amountW;
        private RadioGroup accountW;
        private String accountTypeW;



        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_withdraw);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();
            goBackW = findViewById(R.id.confirm_button2);
            amountW = findViewById(R.id.change_1);
            accountW = findViewById(R.id.zHelp);


            accountW.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.check_button) {
                        Toast.makeText(getApplicationContext(), "Checking", Toast.LENGTH_LONG).show();
                        accountTypeW = "WChecking";
                    } else if (i == R.id.save_button) {
                        Toast.makeText(getApplicationContext(), "Savings", Toast.LENGTH_LONG).show();
                        accountTypeW = "WSavings";
                    } else {
                        accountTypeW = "WNone";
                    }
                }
            });

            goBackW.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String getAmountW = amountW.getText().toString();
                    String getAccountW = accountTypeW;
                    if (getAmountW == null || getAmountW.isEmpty() || getAmountW.isBlank() || !radioCheck()) {
                        Intent intent = new Intent();
                        setResult(Activity.RESULT_CANCELED, intent);
                        finish();
                    } else {
                        Intent intentW = new Intent();
                        intentW.putExtra("amountW", getAmountW);
                        intentW.putExtra("accountW", getAccountW);
                        setResult(Activity.RESULT_OK, intentW);
                        finish();
                    }

                }
            });
        }
    protected boolean radioCheck() {
        if(accountW.getCheckedRadioButtonId() == -1) {
            return false;
        } else {
            return true;
        }
    }

}
