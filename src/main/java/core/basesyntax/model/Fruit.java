package core.basesyntax.model;

public class Fruit {
    private String name;
    private int amount;

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
    public String toString() {
        return "Fruit{"
                + "name='" + name + '\''
                + ", amount=" + amount
                + '}';
    }
}
