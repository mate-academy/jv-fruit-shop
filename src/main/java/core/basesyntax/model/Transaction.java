package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private Fruit fruit;
    private Integer sum;

    public Transaction() {
    }

    public Transaction(Operation operation, Fruit fruit, Integer sum) {
        this.operation = operation;
        this.fruit = fruit;
        this.sum = sum;
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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
