package com.example.opeyemi.dailybudget.com.example.opeyemi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.opeyemi.dailybudget.R;
import com.example.opeyemi.dailybudget.com.example.opeyemi.datamodel.BalanceEntry;

import java.util.ArrayList;

/**
 * Created by opeyemi on 11/07/2016.
 */
public class BalanceEntryListViewAdapter extends ArrayAdapter<BalanceEntry> {

    public BalanceEntryListViewAdapter(Context context, ArrayList<BalanceEntry> entryList) {
        super(context, 0 ,entryList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BalanceEntry entry = getItem(position);

        if(convertView == null){

            convertView = LayoutInflater.from(getContext())
                                       .inflate(R.layout.balance_entry_row,parent,false);
        }

        TextView tvAmount = (TextView)convertView.findViewById(R.id.tvAmount);


        tvAmount.setText(Double.toString(entry.getAmount()));


        return convertView;

    }
}
