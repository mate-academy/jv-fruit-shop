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
    public int hashCode() {
        int result = 17;
        result = result * 31 + (name == null ? null : name.hashCode());
        return result;
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
        return (name == name || name != null
                && name.equals(fruit.name));
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "name='" + name + '\''
                + '}';
    }
}
