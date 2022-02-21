package model;

public class FruitModel implements Commodity {
    private String fruitName;
    private int amount;

    public FruitModel(String fruitName, int amount) {
        this.fruitName = fruitName;
        this.amount = amount;
    }

    @Override
    public String getName() {
        return fruitName;
    }

    @Override
    public void setName(String name) {
        fruitName = name;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FruitModel{"
                + "fruitName='" + fruitName + '\''
                + ", amount=" + amount + '}';
    }
}
