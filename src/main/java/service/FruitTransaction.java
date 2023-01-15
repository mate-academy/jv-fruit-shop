package service;

import model.Fruit;

public class FruitTransaction {
    private String transactionName;
    private Fruit getFruit;
    private int getAmount;

    public FruitTransaction(String transactionName, Fruit getFruit, int getAmount) {
        this.transactionName = transactionName;
        this.getFruit = getFruit;
        this.getAmount = getAmount;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public Fruit getGetFruit() {
        return getFruit;
    }

    public int getGetAmount() {
        return getAmount;
    }
}
