package core.basesyntax;

public class PurchaseOperation implements OperationHandler {
    public void handle(FruitTransaction transaction) {
        Storage.subtract(transaction.getFruit(), transaction.getQuantity());
    }
}
