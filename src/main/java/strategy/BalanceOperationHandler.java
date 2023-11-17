package strategy;

import model.FruitTransaction;
import storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Storage.fruitQuantities.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
