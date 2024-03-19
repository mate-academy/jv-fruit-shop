package core.basesyntax.model;

public abstract sealed class Operation permits Balance, Purchase, Supply, Return {
    private final String product;
    private final int amount;

    public Operation(String product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }
}
