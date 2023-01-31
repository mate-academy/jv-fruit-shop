package core.basesyntax.model;

public class Transaction {
    private String type;
    private String fruitName;
    private int amount;

    public Transaction(String type, String name, int amount) {
        this.type = type;
        this.fruitName = name;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }
}
