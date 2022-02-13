package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private final FruitType fruitType;

    public Fruit(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return fruitType == fruit.fruitType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitType);
    }

    public enum FruitType {
        APPLE("apple"),
        PEAR("pear"),
        BANANA("banana"),
        PLUM("plum"),
        ORANGE("orange"),
        GRAPEFRUIT("grapefruit"),
        MANGO("mango");

        private final String asString;

        FruitType(String fruitType) {
            this.asString = fruitType;
        }

        public String getAsString() {
            return asString;
        }

        public static FruitType getAsConstant(String fruitString) {
            for (FruitType type: FruitType.values()) {
                if (type.asString.equals(fruitString)) {
                    return type;
                }
            }
            return null;
        }
    }
}
