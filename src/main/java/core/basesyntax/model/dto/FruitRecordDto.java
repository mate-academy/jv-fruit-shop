package core.basesyntax.model.dto;

import core.basesyntax.model.Operation;

public class FruitRecordDto {
    private final Operation operation;
    private final String name;
    private final int quantity;

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
