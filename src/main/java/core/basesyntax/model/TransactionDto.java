package core.basesyntax.model;

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
}
