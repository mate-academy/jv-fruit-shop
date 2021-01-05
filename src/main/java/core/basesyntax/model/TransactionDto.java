package core.basesyntax.model;

public class TransactionDto {
    private Operation operation;
    private Fruit fruit;
    private Integer count;

    public TransactionDto(Operation operation, Fruit fruit, Integer count) {
        this.operation = operation;
        this.fruit = fruit;
        this.count = count;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
