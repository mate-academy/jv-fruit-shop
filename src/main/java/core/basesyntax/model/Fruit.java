package core.basesyntax.model;

public enum Fruit {
    APPLE("apple"),
    BANANA("banana"),
    ORANGE("orange"),
    LEMON("lemon");

    private String fruitName;

    Fruit(String name) {
        this.fruitName = name;
    }

    public String getFruitName() {
        return fruitName;
    }
}
