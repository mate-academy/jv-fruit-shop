package service.impl;

import static db.Storage.fruitStorage;

import model.FruitTransaction;
import service.OperationHandler;

public class AddingOperationHandler implements OperationHandler {
    public void handle(FruitTransaction transaction) {
        int quantity = fruitStorage.getOrDefault(transaction.getFruit(), 0)
                + transaction.getQuantity();
        fruitStorage.put(transaction.getFruit(), quantity);
    }
}
