package core.basesyntax.model;

public abstract class Transaction {
    private OperationType operationType;
    private String productType;
    private int transactionValue;

    public Transaction(OperationType operationType, String productType, int transactionValue) {
        this.operationType = operationType;
        this.productType = productType;
        this.transactionValue = transactionValue;
    }

    public OperationType getTransactionType() {
        return operationType;
    }

    public String getProductType() {
        return productType;
    }

    public int getTransactionValue() {
        return transactionValue;
    }
}
