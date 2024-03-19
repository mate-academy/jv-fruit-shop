package core.basesyntax.models;

public record Fruit(String fruitName) implements Comparable<Fruit> {

    @Override
    public int compareTo(Fruit fruit) {
        return this.fruitName.compareTo(fruit.fruitName);
    }
}
