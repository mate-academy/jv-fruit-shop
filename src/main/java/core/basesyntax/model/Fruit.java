package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;

    public Fruit(String fruit) {
        this.name = fruit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass() == this.getClass()) {
            Fruit value = (Fruit) object;
            return Objects.equals(value.getName(), name);
        }
        return false;
    }
}
