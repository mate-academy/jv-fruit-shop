package core.basesyntax.model;

public class FruitInStorage {
    private String name;
    private int amount;

    public FruitInStorage(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
