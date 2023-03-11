package core.basesyntax.model;

public enum Fruit {
    BANANA("banana"),
    APPLE("apple");

    private String fruitName;

    Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitName() {
        return fruitName;
    }
}
