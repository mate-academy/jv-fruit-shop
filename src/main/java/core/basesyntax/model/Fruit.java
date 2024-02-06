package core.basesyntax.model;

public class Fruit {
    private String fruitName;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
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

        return fruitName.equals(fruit.fruitName);
    }

    @Override
    public int hashCode() {
        return fruitName.hashCode();
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "fruitName='"
                + fruitName
                + '\''
                + '}';
    }
}
