package core.basesyntax.model;

public enum Fruit {
    BANANA("banana"),
    APPLE("apple");

    private final String fruitName;
    Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitName() {
        return fruitName;
    }
}
