package model;

import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    private TransactionType transaction;
    private String fruit;
    private int quantity;

    public TransactionType getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionType transaction) {
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

    public enum TransactionType {
        BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

        private static final Map<String, TransactionType> transactionMap = new HashMap<>();
        private final String transaction;

        static {
            for (TransactionType transaction : TransactionType.values()) {
                transactionMap.put(transaction.getTransaction(), transaction);
            }
        }

        TransactionType(String transaction) {
            this.transaction = transaction;
        }

        public String getTransaction() {
            return transaction;
        }

        public static TransactionType get(String transaction) {
            return transactionMap.get(transaction);
        }
    }
}
