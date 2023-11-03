package operation.impl;

import db.Storage;
import model.FruitTransaction;
import operation.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void accept(FruitTransaction fruitTransaction) {
        Storage.setAmount(fruitTransaction.fruit(), fruitTransaction.amount());
    }
}
