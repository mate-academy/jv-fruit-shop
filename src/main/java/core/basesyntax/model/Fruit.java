package core.basesyntax.model;

public class Fruit {
    private String fruitName;
    private int amount;

    public Fruit(String name) {
        this.fruitName = name;
    }

    public Fruit(String name, int amount) {
        this.fruitName = name;
        this.amount = amount;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
