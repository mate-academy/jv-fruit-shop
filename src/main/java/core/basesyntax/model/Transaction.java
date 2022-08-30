package core.basesyntax.model;

import core.basesyntax.strategy.Strategy;

public class Transaction {
    private Strategy strategy;
    private String fruit;
    private int value;

    public Transaction(Strategy strategy, String fruit, int value) {
        this.strategy = strategy;
        this.fruit = fruit;
        this.value = value;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public String getFruit() {
        return fruit;
    }

    public int getValue() {
        return value;
    }
}
