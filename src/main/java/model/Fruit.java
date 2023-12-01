package model;

public class Fruit {
    private Transaction transaction;
    private String fruit;
    private int quantity;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "transaction=" + transaction
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
