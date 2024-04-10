package fruit.shop.model;

public class FruitTransaction {
    private final Fruit fruit;
    private final Transaction transaction;
    private final int quantity;

    public FruitTransaction(Fruit fruit, Transaction transaction, int quantity) {
        this.fruit = fruit;
        this.transaction = transaction;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public int getQuantity() {
        return quantity;
    }
}
