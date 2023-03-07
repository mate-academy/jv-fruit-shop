package core.basesyntax.model;

public class FruitTransaction implements Transaction {
    private final String productName;
    private final Operation type;
    private final int quantity;

    public FruitTransaction(Operation type, String productName, int quantity) {
        this.type = type;
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public Operation getOperationType() {
        return type;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
