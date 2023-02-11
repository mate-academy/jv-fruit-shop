package core.basesyntax.model;

public class FruitTransaction {
    private String operation;
    private Fruit fruit;
    private Integer count;

    public FruitTransaction(String operation, Fruit fruit, Integer count) {
        this.operation = operation;
        this.fruit = fruit;
        this.count = count;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
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

    @Override
    public java.lang.String toString() {
        return "FruitTransaction{"
                + "operation=" + operation
                + ", fruit=" + fruit
                + ", count=" + count
                + '}';
    }
}
