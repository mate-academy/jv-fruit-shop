package core.basesyntax.model;

public class Fruit {
    private final String name;
    private int amount;

    public Fruit(String name) {
        this.name = name;
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

    public String getStock() {
        return name + "," + amount;
    }
}
