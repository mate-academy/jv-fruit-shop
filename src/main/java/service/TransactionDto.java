package service;

import model.Fruit;
import model.OperationType;

public class TransactionDto {
    private OperationType type;
    private Fruit fruit;
    private Integer quantity;

    public TransactionDto(OperationType type, Fruit fruit, Integer quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public OperationType getType() {
        return type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
