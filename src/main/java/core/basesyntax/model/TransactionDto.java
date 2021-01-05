package core.basesyntax.model;

import java.util.Objects;

public class TransactionDto {
    private Fruit fruit;
    private Integer number;
    private Operation operation;

    public TransactionDto(Fruit fruit, Integer number, Operation operation) {
        this.fruit = fruit;
        this.number = number;
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionDto that = (TransactionDto) o;
        return Objects.equals(fruit, that.fruit)
                && Objects.equals(number, that.number)
                && operation == that.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit, number, operation);
    }
}
