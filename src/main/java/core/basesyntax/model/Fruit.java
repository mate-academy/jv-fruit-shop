package core.basesyntax.model;

public enum Fruit {
    BANANA("banana"),
    APPLE("apple");

    private String name;

    Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
