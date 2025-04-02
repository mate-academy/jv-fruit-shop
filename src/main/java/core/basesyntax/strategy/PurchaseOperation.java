package core.basesyntax.strategy;

public class PurchaseOperation implements OperationHandler {

    @Override
    public int warehouse(int balance, int quantity) {
        if (balance < quantity) {
            throw new RuntimeException("Fruits balance less than " + quantity);
        }
        return balance - quantity;
    }
}
