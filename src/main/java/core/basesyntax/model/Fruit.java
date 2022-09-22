package core.basesyntax.model;

public enum Fruit {

    BANANA("banana"),
    APPLE("apple");

    private final String fruitTitle;

    Fruit(String operationTitle){
        this.fruitTitle = operationTitle;
    }

    public String getFruitTitle() {
        return fruitTitle;
    }
}
