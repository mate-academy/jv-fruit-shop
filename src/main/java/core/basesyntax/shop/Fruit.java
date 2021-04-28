package core.basesyntax.shop;

import java.util.Objects;

public class Fruit implements Comparable<Fruit> {
    private String name;

    public Fruit(String name) {
        this.name = name.toLowerCase();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruits = (Fruit) o;
        return Objects.equals(name, fruits.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Fruit o) {
        return name.compareTo(o.getName());
    }
}
