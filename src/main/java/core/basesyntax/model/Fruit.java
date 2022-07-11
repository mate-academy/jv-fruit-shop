package core.basesyntax.model;

import java.util.List;

public class Fruit {
    private String fruitName;
    private int quantity;
    private List<FruitTransaction> fruitTransactions;

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<FruitTransaction> getFruitTransactions() {
        return fruitTransactions;
    }

    public void setFruitTransactions(List<FruitTransaction> fruitTransactions) {
        this.fruitTransactions = fruitTransactions;
    }
}
