package core.basesyntax.model;

public final class Fruit {
    private final String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return name.equals(fruit.name);
    }

    @Override
    public int hashCode() {
        return 31 + 17 * name.hashCode();
    }
}

