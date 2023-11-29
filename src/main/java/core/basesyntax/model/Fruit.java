package core.basesyntax.model;

public class Fruit {
    private String name;
    private int amount;

    public Fruit(String name) {
        this.name = name;
        this.amount = 0;
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
