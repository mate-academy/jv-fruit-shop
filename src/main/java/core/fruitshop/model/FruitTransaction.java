package core.fruitshop.model;

import core.fruitshop.OperationType;

public class FruitTransaction {
    private final OperationType type;
    private final String productName;
    private final int amount;

    public FruitTransaction(OperationType type, String productName, int amount) {
        this.type = type;
        this.productName = productName;
        this.amount = amount;
    }

    public OperationType getType() {
        return type;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmount() {
        return amount;
    }
}
