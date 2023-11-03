package operation.impl;

import db.Storage;
import model.FruitTransaction;
import operation.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {

    @Override
    public void accept(FruitTransaction fruitTransaction) {
        if (Storage.getFruitsAndAmount().get(fruitTransaction.fruit()) >= 0) {
            Storage.addFruit(fruitTransaction.fruit(), -fruitTransaction.amount());
        }
    }
}
