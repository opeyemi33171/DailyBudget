package com.example.opeyemi.dailybudget.com.example.opeyemi.datamodel;

import java.io.Serializable;

/**
 * Created by opeyemi on 10/07/2016.
 */
public class BalanceEntry implements Serializable {

    public Boolean getIncome() {
        return isIncome;
    }

    public void setIncome(Boolean income) {
        isIncome = income;
    }

    private Boolean isIncome;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private double amount;

    public Category getTag() {
        return tag;
    }

    public void setTag(Category tag) {
        this.tag = tag;
    }

    private Category tag;

    public BalanceEntry(){

    }
     public  BalanceEntry(Double amount, Boolean isIncome){
         this.isIncome = isIncome;
         this.amount = amount;
     }


}
