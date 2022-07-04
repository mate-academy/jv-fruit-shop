package core.basesyntax.model;

public enum Fruit {

    BANANA("banana"),
    APPLE("apple");
    private String fruit;

    Fruit(String fruit) {
        this.fruit = fruit;
    }

    public String getFruit() {
        return fruit;
    }

}
