package com.example.atmapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainScreen extends AppCompatActivity {
    private Button transfer, withdraw, deposit;
    private TextView balance, checking, saving;
    private int numberBalance, numberChecking, numberSaving;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        deposit = findViewById(R.id.deposit_id);
        withdraw = findViewById(R.id.withdraw_id);
        transfer = findViewById(R.id.transfer_id);
        balance = findViewById(R.id.balance);
        checking = findViewById(R.id.checking);
        saving = findViewById(R.id.savings);


        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getBalance = balance.getText().toString();
                String getChecking = checking.getText().toString();
                String getSavings = saving.getText().toString();


                Intent intent = new Intent(MainScreen.this, DepositScreen.class);
                intent.putExtra("balance", getBalance);
                intent.putExtra("checking", getChecking);
                intent.putExtra("savings", getSavings);
                startActivityForResult(intent, 1);
            }
        });
        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getBalance = balance.getText().toString();
                String getChecking = checking.getText().toString();
                String getSavings = saving.getText().toString();


                Intent intent = new Intent(MainScreen.this, WithdrawActivity.class);
                intent.putExtra("balance", getBalance);
                intent.putExtra("checking", getChecking);
                intent.putExtra("savings", getSavings);
                startActivityForResult(intent, 2);
            }
        });
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getBalance = balance.getText().toString();
                String getChecking = checking.getText().toString();
                String getSavings = saving.getText().toString();


                Intent intent = new Intent(MainScreen.this, TransferScreen.class);
                intent.putExtra("balance", getBalance);
                intent.putExtra("checking", getChecking);
                intent.putExtra("savings", getSavings);
                startActivityForResult(intent, 3);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            if(resultCode == Activity.RESULT_OK) {
                String amount = data.getStringExtra("amount");
                String account = data.getStringExtra("account");
                int change = 0;
                int account1 = 0;
                int account2 = 0;
                String getBalance = balance.getText().toString();
                String getChecking = checking.getText().toString();
                String getSavings = saving.getText().toString();
                if(account.equals("Checking")){
                    change = Integer.parseInt(amount);
                    account1 = Integer.parseInt(getBalance);
                    account2 = Integer.parseInt(getChecking);
                    if(change < account1){
                        account1 = account1 - change;
                        account2 = account2 + change;
                        balance.setText(String.valueOf(account1));
                        checking.setText(String.valueOf(account2));
                    } else{
                        Toast.makeText(getApplicationContext(), "Deposit failed", Toast.LENGTH_LONG).show();
                    }
                } else if(account.equals("Savings")){
                    change = Integer.parseInt(amount);
                    account1 = Integer.parseInt(getBalance);
                    account2 = Integer.parseInt(getSavings);
                    if(change < account1){
                        account1 = account1 - change;
                        account2 = account2 + change;
                        balance.setText(String.valueOf(account1));
                        saving.setText(String.valueOf(account2));
                    } else{
                        Toast.makeText(getApplicationContext(), "Deposit failed", Toast.LENGTH_LONG).show();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Deposit failed", Toast.LENGTH_LONG).show();
            }
        } else if(requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                String amountW = data.getStringExtra("amountW");
                String accountW = data.getStringExtra("accountW");
                int change = 0;
                int account3 = 0;
                int account4 = 0;
                String getBalance = balance.getText().toString();
                String getChecking = checking.getText().toString();
                String getSavings = saving.getText().toString();
                if (accountW.equals("WChecking")) {
                    change = Integer.parseInt(amountW);
                    account3 = Integer.parseInt(getBalance);
                    account4 = Integer.parseInt(getChecking);
                    if (change < account4) {
                        account3 = account3 + change;
                        account4 = account4 - change;
                        balance.setText(String.valueOf(account3));
                        checking.setText(String.valueOf(account4));
                    } else {
                        Toast.makeText(getApplicationContext(), "Withdrawal failed", Toast.LENGTH_LONG).show();
                    }
                } else if (accountW.equals("WSavings")) {
                    change = Integer.parseInt(amountW);
                    account3 = Integer.parseInt(getBalance);
                    account4 = Integer.parseInt(getSavings);
                    if (change < account4) {
                        account3 = account3 + change;
                        account4 = account4 - change;
                        balance.setText(String.valueOf(account3));
                        saving.setText(String.valueOf(account4));
                    } else {
                        Toast.makeText(getApplicationContext(), "Withdrawal failed", Toast.LENGTH_LONG).show();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Withdrawal failed", Toast.LENGTH_LONG).show();
            }
        } else if(requestCode == 3) {
            if (resultCode == Activity.RESULT_OK) {
                String amountT = data.getStringExtra("amountT");
                String accountT = data.getStringExtra("accountT");
                String accountT2 = data.getStringExtra("accountT2");
                int change = 0;
                int account5 = 0;
                int account6 = 0;
                String getChecking = checking.getText().toString();
                String getSavings = saving.getText().toString();
                if (accountT.equals("TChecking") && accountT2.equals("T2Savings")) {
                    change = Integer.parseInt(amountT);
                    account5 = Integer.parseInt(getChecking);
                    account6 = Integer.parseInt(getSavings);
                    if (change < account5) {
                        account5 = account5 - change;
                        account6 = account6 + change;
                        checking.setText(String.valueOf(account5));
                        saving.setText(String.valueOf(account6));
                    } else {
                        Toast.makeText(getApplicationContext(), "Withdrawal failed", Toast.LENGTH_LONG).show();
                    }
                } else if (accountT.equals("TSavings") && accountT2.equals("T2Checking")) {
                    change = Integer.parseInt(amountT);
                    account5 = Integer.parseInt(getSavings);
                    account6 = Integer.parseInt(getChecking);
                    if (change < account5) {
                        account5 = account5 - change;
                        account6 = account6 + change;
                        saving.setText(String.valueOf(account5));
                        checking.setText(String.valueOf(account6));
                    } else {
                        Toast.makeText(getApplicationContext(), "Withdrawal failed", Toast.LENGTH_LONG).show();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Withdrawal failed", Toast.LENGTH_LONG).show();
            }
        }
    }
}
