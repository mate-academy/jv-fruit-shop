package service.impl;

import model.FruitTransaction;
import service.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.updateStorage(transaction.getFruit(), transaction.getQuantity());
    }
}
