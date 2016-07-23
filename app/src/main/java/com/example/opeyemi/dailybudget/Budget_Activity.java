package com.example.opeyemi.dailybudget;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.opeyemi.dailybudget.com.example.opeyemi.adapters.BalanceEntryListViewAdapter;
import com.example.opeyemi.dailybudget.com.example.opeyemi.datamodel.BalanceEntry;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Budget_Activity extends AppCompatActivity {

   public static Double budget = 400D;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Your balance");

        final TextView budgetTextview = (TextView)findViewById(R.id.budget);
        budgetTextview.setText(budget.toString());


        final ArrayList<BalanceEntry> entries = new ArrayList<>();
        final BalanceEntryListViewAdapter adapter = new BalanceEntryListViewAdapter(this, entries);
        final ListView balanceEntryListView = (ListView)findViewById(R.id.balanceEntryListView);

        balanceEntryListView.setAdapter(adapter);





        //when you debug get rid if the linearlayout in balance_entry and try with just a listview.

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent navBalanceEntryActivity = new  Intent(Budget_Activity.this, Balance_Entry_Activity.class) ;
                startActivity(navBalanceEntryActivity);

                try {
                    budget = getIntent().getExtras().getDouble("NewBudget");
                    budgetTextview.setText(budget.toString());


                    entries.add(Balance_Entry_Activity.entry);
                    adapter.notifyDataSetChanged();

                }
                catch (Exception e ){}
            }
        });


    }

}
