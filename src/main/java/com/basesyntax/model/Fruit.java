package com.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object anotherFruit) {
        if (this == anotherFruit) {
            return true;
        }
        if (anotherFruit == null || getClass() != anotherFruit.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) anotherFruit;
        return Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
