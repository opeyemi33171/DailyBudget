package com.example.opeyemi.dailybudget;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.opeyemi.dailybudget.com.example.opeyemi.adapters.BalanceEntryListViewAdapter;
import com.example.opeyemi.dailybudget.com.example.opeyemi.datamodel.BalanceEntry;

import java.util.ArrayList;

public class Budget_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Your balance");


        final ArrayList<BalanceEntry> entries = new ArrayList<>();
        BalanceEntryListViewAdapter adapter = new BalanceEntryListViewAdapter(this, entries);
        ListView balanceEntryListView = (ListView)findViewById(R.id.balanceEntryListView);

        balanceEntryListView.setAdapter(adapter);

        entries.add(new BalanceEntry(200D));
        entries.add(new BalanceEntry(300D));
        adapter.notifyDataSetChanged();

        //when you debug get rid if the linearlayout in balance_entry and try with just a listview.

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_budget_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
