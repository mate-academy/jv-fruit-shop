package core.basesyntax.model;

public class Apple extends Fruit {
    private static final String NAME_OF_FRUIT = "apple";

    public Apple(int quantity) {
        super(NAME_OF_FRUIT, quantity);
    }
}
