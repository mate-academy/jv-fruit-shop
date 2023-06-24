package service;

import model.Fruit;

public class FruitTransaction {
    private String transactionName;
    private Fruit fruit;
    private int quantity;

    public FruitTransaction(String transactionName, Fruit getFruit, int getAmount) {
        this.transactionName = transactionName;
        this.fruit = getFruit;
        this.quantity = getAmount;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
