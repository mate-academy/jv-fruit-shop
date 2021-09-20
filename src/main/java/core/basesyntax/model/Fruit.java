package core.basesyntax.model;

public class Fruit {
    private String fruitName;

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitName() {
        return fruitName;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (fruitName == null ? 0 : fruitName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object fruit) {
        if (!(fruit != null && fruit.getClass().equals(Fruit.class))) {
            return false;
        }
        Fruit castedFruit = (Fruit) fruit;
        return ((fruitName == castedFruit.fruitName))
                || (fruitName != null && fruitName.equals(castedFruit.getFruitName()));
    }
}
