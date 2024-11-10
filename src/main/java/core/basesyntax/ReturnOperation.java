package core.basesyntax;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(ShopStorage storage, FruitTransaction transaction) {
        storage.updateFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}

