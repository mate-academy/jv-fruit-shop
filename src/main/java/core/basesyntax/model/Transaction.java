package core.basesyntax.model;

public class Transaction {
    private TransactionType transactionType;
    private Fruit fruit;
    private int amount;

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public enum TransactionType {
        BALANCE("b"),
        PURCHASE("p"),
        RETURN("r"),
        SUPPLY("s");

        private final String transactionName;

        TransactionType(String transactionCode) {
            this.transactionName = transactionCode;
        }

        public String getTransactionName() {
            return transactionName;
        }

        public static TransactionType getTransactionTypeByCode(String codeCharacter) {
            for (TransactionType transactionType : values()) {
                if (transactionType.transactionName.equals(codeCharacter)) {
                    return transactionType;
                }
            }
            throw new RuntimeException("no such type code: " + codeCharacter);
        }
    }
}
