package service.impl.operations;

import db.Storage;
import service.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void performOperation(String fruit, int amount) {
        Storage.addFruits(fruit, amount);
    }
}
