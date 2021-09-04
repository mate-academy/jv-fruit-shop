package core.basesyntax;

public class FruitListOperation {
    private String fruitOperation;
    private Fruit fruit;

    public FruitListOperation(String fruitOperation, Fruit fruit) {
        this.fruitOperation = fruitOperation;
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public String getFruitOperation() {
        return fruitOperation;
    }
}
