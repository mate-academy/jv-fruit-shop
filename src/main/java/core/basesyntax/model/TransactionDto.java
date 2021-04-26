package core.basesyntax.model;

import java.util.Objects;

public class TransactionDto {
    private final Operation operation;
    private final Product fruit;
    private final int amount;

    public TransactionDto(Operation operation, Product fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public Product getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object dto) {
        if (this == dto) {
            return true;
        }
        if (dto == null || getClass() != dto.getClass()) {
            return false;
        }
        TransactionDto otherDto = (TransactionDto) dto;
        return amount == otherDto.amount
                && operation == otherDto.operation
                && Objects.equals(fruit, otherDto.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, amount);
    }

    @Override
    public String toString() {
        return "ProductFactory{" + "operation=" + operation
                + ", fruit=" + fruit
                + ", amount=" + amount + '}';
    }
}
