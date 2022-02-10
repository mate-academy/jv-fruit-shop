package core.basesyntax.model;

public class Transaction {
    private final Fruit fruit;
    private final TransactionType transactionType;
    private final int quantity;

    public Transaction(Fruit fruit, TransactionType transactionType, int quantity) {
        this.fruit = fruit;
        this.transactionType = transactionType;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum TransactionType {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String transactionType;

        TransactionType (String transactionType) {
            this.transactionType = transactionType;
        }

        public String getTransactionType() {
            return this.transactionType;
        }
    }
}
