package strategy;

import model.FruitTransaction;
import storage.Storage;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public int handle(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        return fruitTransaction.getQuantity();
    }
}
