package main.model.dto;

import main.model.Operation;

public class FruitRecordDto {
    Operation operation;
    String name;
    int quantity;

    public FruitRecordDto(Operation operation, String name, int quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
