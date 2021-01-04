package core.basesyntax.model;

import java.util.Objects;

/**
 * Feel free to remove this class and create your own.
 */
public class Fruits {
    private String name;

    public Fruits() {
    }

    public Fruits(Fruits fruit) {
        this.name = fruit.name;
    }

    public Fruits(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruits fruits = (Fruits) o;
        return Objects.equals(name, fruits.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
