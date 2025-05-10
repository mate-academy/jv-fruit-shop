package core.basesyntax;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(ShopStorage storage, FruitTransaction transaction) {
        storage.updateFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
