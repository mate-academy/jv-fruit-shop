package core.basesyntax.model;

public class Transaction {
    private Fruit fruit;
    private Integer amount;
    private String operation;

    public Transaction(String operation, Fruit fruit, Integer amount) {
        this.fruit = fruit;
        this.amount = amount;
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
