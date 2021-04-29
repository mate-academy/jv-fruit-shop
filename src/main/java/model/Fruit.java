package model;

import exception.InvalidFruitTypeException;
import java.util.Arrays;
import java.util.Objects;

public class Fruit {
    private Type type;

    public Fruit(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fruit)) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return Objects.equals(type, fruit.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    public static Fruit.Type getFruitType(String type) {
        return Arrays.stream(Fruit.Type.values())
                .filter(t -> t.getType().equals(type))
                .findAny()
                .orElseThrow(() -> new InvalidFruitTypeException("Incorrect Type of Fruit"));
    }

    public enum Type {
        APPLE("apple"),
        BANANA("banana");
        private String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
