package com.example.opeyemi.dailybudget;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.opeyemi.dailybudget.com.example.opeyemi.datamodel.BalanceEntry;

public class Balance_Entry_Activity extends AppCompatActivity {


    public static BalanceEntry entry;
    boolean isIncome = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance__entry_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("New entry");



//region Toggle buttons
        final Button mIncomeToggle = (Button)findViewById(R.id.incomeToggle);
        final Button mExpensesToggle = (Button)findViewById(R.id.expenseToggle);

        mIncomeToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorDrawable incomeColor = (ColorDrawable)mIncomeToggle.getBackground();
                int colorId =incomeColor.getColor();

                if(colorId == R.color.Green){
                    mIncomeToggle.setBackgroundColor(getResources().getColor(R.color.Grey));
                    mIncomeToggle.setTextColor(getResources().getColor(R.color.Black));

                    mExpensesToggle.setBackgroundColor(getResources().getColor(R.color.Green));
                    mExpensesToggle.setTextColor(getResources().getColor(R.color.White));

                    isIncome = false;
                }
                else{
                    mIncomeToggle.setBackgroundColor(getResources().getColor(R.color.Green));
                    mIncomeToggle.setTextColor(getResources().getColor(R.color.White));

                    mExpensesToggle.setBackgroundColor(getResources().getColor(R.color.Grey));
                    mExpensesToggle.setTextColor(getResources().getColor(R.color.Black));

                    isIncome =true;
                }
            }
        });


        mExpensesToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorDrawable expenseColor  = (ColorDrawable)mIncomeToggle.getBackground();
                int colorId =expenseColor.getColor();

                if(colorId == R.color.Green){
                    mExpensesToggle.setBackgroundColor(getResources().getColor(R.color.Grey));
                    mExpensesToggle.setTextColor(getResources().getColor(R.color.Black));

                    mIncomeToggle.setBackgroundColor(getResources().getColor(R.color.Green));
                    mIncomeToggle.setTextColor(getResources().getColor(R.color.White));

                    isIncome = true;
                }
                else{
                    mExpensesToggle.setBackgroundColor(getResources().getColor(R.color.Green));
                    mExpensesToggle.setTextColor(getResources().getColor(R.color.White));

                    mIncomeToggle.setBackgroundColor(getResources().getColor(R.color.Grey));
                    mIncomeToggle.setTextColor(getResources().getColor(R.color.Black));

                    isIncome = false;

                }

            }
        });
//endregion toggle


        final EditText amount = (EditText)findViewById(R.id.amount);
        Button mSaveButton = (Button)findViewById(R.id.saveButton);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BalanceEntry newEntry = new BalanceEntry(Double.parseDouble(amount.getText().toString()),
                        isIncome);

                entry  =  newEntry;

                if(newEntry.getIncome() ==  true){

                    Budget_Activity.budget+=newEntry.getAmount();
                    Intent backToBudgetActivity = new Intent(Balance_Entry_Activity.this, Budget_Activity.class);
                    backToBudgetActivity.putExtra("NewBudget", Budget_Activity.budget);
                    startActivity(backToBudgetActivity);

                }
                else{

                    Budget_Activity.budget-=newEntry.getAmount();
                    Intent backToBudgetActivity = new Intent(Balance_Entry_Activity.this, Budget_Activity.class);
                    backToBudgetActivity.putExtra("NewBudget", Budget_Activity.budget);
                    startActivity(backToBudgetActivity);
                }
            }
        });


    }
}
