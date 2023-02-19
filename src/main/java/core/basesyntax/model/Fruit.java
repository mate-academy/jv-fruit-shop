package core.basesyntax.model;

public enum Fruit {
    APPLE("apple"), BANANA("banana"), ORANGE("orange");

    private String name;

    Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
