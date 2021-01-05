package core.basesyntax.model;

public class Fruit implements Comparable<Fruit> {
    private String fruitName;

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitName() {
        return fruitName;
    }

    @Override
    public int compareTo(Fruit anotherFruit) {
        return fruitName.compareTo(anotherFruit.getFruitName());
    }
}
