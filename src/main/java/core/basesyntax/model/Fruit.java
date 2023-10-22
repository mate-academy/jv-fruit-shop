package core.basesyntax.model;

public class Fruit {
    private final String name;

    public Fruit(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fruit)) {
            return false;
        }
        final Fruit fruit = (Fruit) o;
        return name.equals(fruit.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Fruit{" + "name='" + name + '\'' + '}';
    }
}
