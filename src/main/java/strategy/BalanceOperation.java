package strategy;

import db.Storage;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        Storage.fruitsStorage.put(fruitTransaction.getFruit(),fruitTransaction.getQuantity());
    }
}
