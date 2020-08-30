package core.basesyntax.service;

import java.util.List;

public class TransactionParser {
    private String operation;
    private String fruit;
    private Integer quantity;
    private String date;

    public TransactionParser(List<String> transaction) {
        this.operation = transaction.get(0);
        this.fruit = transaction.get(1);
        this.quantity = Integer.parseInt(transaction.get(2));
        this.date = transaction.get(3);
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
