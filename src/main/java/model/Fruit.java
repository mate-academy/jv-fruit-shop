package model;

public class Fruit {
    private FruitType fruitType;

    public Fruit(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "fruitType=" + fruitType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fruit fruit = (Fruit) o;

        return fruitType == fruit.fruitType;
    }

    @Override
    public int hashCode() {
        return fruitType != null ? fruitType.hashCode() : 0;
    }
}
