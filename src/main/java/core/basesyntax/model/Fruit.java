package core.basesyntax.model;

public class Fruit {
    private final String name;
    private final int amount;

    public Fruit(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getFruitName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
