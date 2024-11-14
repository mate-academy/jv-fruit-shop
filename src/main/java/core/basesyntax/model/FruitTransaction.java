package core.basesyntax.model;

import jdk.dynalink.Operation;

import java.util.ArrayList;
import java.util.List;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitTransaction() {
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<FruitTransaction> parseTransaction(String[] transactions) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        for (int i = 1; i < transactions.length; i++) {
            String transaction = transactions[i];
            String[] parts = transaction.split(",");

            Operation operation = Operation.getOperation(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            FruitTransaction fruitTransaction = new FruitTransaction(operation, fruit, quantity);

            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }


}
