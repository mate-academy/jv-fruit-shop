package core.basesyntax.utility;

public enum FruitType {
    BANANA("banana"),
    APPLE("apple");

    private final String name;

    FruitType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
