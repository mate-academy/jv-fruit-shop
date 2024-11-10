package core.basesyntax;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(ShopStorage storage, FruitTransaction transaction) {
        storage.updateFruitQuantity(transaction.getFruit(), -transaction.getQuantity());
    }
}
