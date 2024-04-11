package fruit.shop.model;

public class FruitTransaction {
    private final Fruit fruit;
    private final TransactionType transactionType;
    private final int quantity;

    public FruitTransaction(Fruit fruit, TransactionType transactionType, int quantity) {
        this.fruit = fruit;
        this.transactionType = transactionType;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public TransactionType getTransaction() {
        return transactionType;
    }

    public int getQuantity() {
        return quantity;
    }
}
