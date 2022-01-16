package core.basesyntax.model;

public class Fruit {
    private final String name;
    private int amount;

    public Fruit(String name) {
        this(name, 0);
    }

    public Fruit(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
