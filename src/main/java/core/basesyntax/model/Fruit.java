package core.basesyntax.model;

public class Fruit {
    private String fruit;
    private int amount = 0;

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
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
                + "fruit='" + fruit + '\''
                + ", amount=" + amount
                + '}';
    }
}
