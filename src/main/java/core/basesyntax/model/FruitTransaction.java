package core.basesyntax.model;

import core.basesyntax.database.DataBase;

public class FruitTransaction {
    private DataBase.Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(DataBase.Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public DataBase.Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
