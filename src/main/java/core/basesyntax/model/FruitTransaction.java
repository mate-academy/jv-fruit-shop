package core.basesyntax.model;

public class FruitTransaction {
    private Operation operationType;
    private String productName;
    private int amount;

    public FruitTransaction() {
    }

    public FruitTransaction(Operation operationType, String productType, int amount) {
        this.operationType = operationType;
        this.productName = productType;
        this.amount = amount;
    }

    public Operation getOperationType() {
        return operationType;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmount() {
        return amount;
    }
}
