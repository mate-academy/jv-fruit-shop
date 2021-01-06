package core.basesyntax.model;

public class Fruit implements Comparable<Fruit> {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Fruit fruit) {
        return name.compareTo(fruit.getName());
    }
}
