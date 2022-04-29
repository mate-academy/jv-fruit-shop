package model;

public final class Fruit {
    private final String nameOfFruit;

    public Fruit(String nameOfFruit) {
        this.nameOfFruit = nameOfFruit;
    }

    public String getNameOfFruit() {
        return nameOfFruit;
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

        return nameOfFruit.equals(fruit.nameOfFruit);
    }

    @Override
    public int hashCode() {
        return nameOfFruit.hashCode();
    }

    @Override
    public String toString() {
        return nameOfFruit;
    }
}
