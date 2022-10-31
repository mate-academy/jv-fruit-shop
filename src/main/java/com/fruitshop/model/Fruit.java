package com.fruitshop.model;

public class Fruit {
    private int balance;
    private int supply;
    private int purchase;
    private int returned;
    private int quantityLeft;

    public int getQuantityLeft() {
        return balance + supply + returned - purchase;
    }

    public void setQuantityLeft(int quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public int getPurchase() {
        return purchase;
    }

    public void setPurchase(int purchase) {
        this.purchase = purchase;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "balance=" + balance
                + ", supply=" + supply
                + ", purchase=" + purchase
                + ", returned=" + returned
                + '}';
    }
}
