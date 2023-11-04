package service.impl.operations;

import db.Storage;
import service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void performOperation(String fruit, int amount) {
        Storage.subtractFruits(fruit, amount);
    }
}
