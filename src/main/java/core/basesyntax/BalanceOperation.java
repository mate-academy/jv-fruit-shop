package core.basesyntax;


public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(ShopStorage storage, FruitTransaction transaction) {
        storage.setFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
