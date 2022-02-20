package core.basesyntax.models;

public class Fruit {
    private String name;
    private int amount;

    public Fruit(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public Fruit clone() {
        return new Fruit(name, amount);
    }
}
