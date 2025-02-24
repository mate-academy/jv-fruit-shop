package core.basesyntax;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        try {
            Storage.remove(transaction.getFruit(), transaction.getQuantity());
        } catch (RuntimeException e) {
            throw new RuntimeException("Balance is negative");
        }
    }
}
