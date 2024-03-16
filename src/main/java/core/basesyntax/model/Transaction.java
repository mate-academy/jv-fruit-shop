package core.basesyntax.model;

public abstract class Transaction {
    private String transactionType;
    private String productType;
    private int transactionValue;

    public Transaction(String transactionType, String productType, int transactionValue) {
        this.transactionType = transactionType;
        this.productType = productType;
        this.transactionValue = transactionValue;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getProductType() {
        return productType;
    }

    public int getTransactionValue() {
        return transactionValue;
    }
}
