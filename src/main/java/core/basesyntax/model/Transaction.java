package core.basesyntax.model;

public class Transaction {
    private final Fruit fruit;
    private final TransactionType transactionType;
    private final int quantity;

    public Transaction(TransactionType transactionType, Fruit fruit, int quantity) {
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

        private final String asLetter;

        TransactionType(String transactionType) {
            this.asLetter = transactionType;
        }

        public String getAsLetter() {
            return this.asLetter;
        }

        public static TransactionType getAsConstant(String letter) {
            for (TransactionType type: TransactionType.values()) {
                if (type.asLetter.equals(letter)) {
                    return type;
                }
            }
            return null;
        }
    }
}
