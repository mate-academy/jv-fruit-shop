package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object fruit) {
        if (fruit == this) {
            return true;
        }
        if (fruit == null || fruit.getClass().equals(Fruit.class)) {
            return false;
        }
        Fruit current = (Fruit) fruit;
        return Objects.equals(this.name, current.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
