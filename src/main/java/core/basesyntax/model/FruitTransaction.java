package core.basesyntax.model;

public class FruitTransaction {
    private String operation;
    private Fruit fruit;

    public FruitTransaction(String operation, Fruit fruit) {
        this.operation = operation;
        this.fruit = fruit;
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

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation='" + operation + '\''
                + ", fruit=" + fruit
                + '}';
    }
}
