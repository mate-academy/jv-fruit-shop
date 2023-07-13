package model;

public class PurchaseOperation extends TransactionOperation {
    public PurchaseOperation(String code) {
        super(code);
    }

    public PurchaseOperation() {
        super("p");
    }
}
