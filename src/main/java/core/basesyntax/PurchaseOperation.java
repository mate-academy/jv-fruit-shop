package core.basesyntax;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
