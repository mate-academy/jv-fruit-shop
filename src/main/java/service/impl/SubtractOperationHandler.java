package service.impl;

import static db.Storage.fruitStorage;

import model.FruitTransaction;
import service.OperationHandler;

public class SubtractOperationHandler implements OperationHandler {
    public void handle(FruitTransaction transaction) {
        int quantity = fruitStorage.getOrDefault(transaction.getFruit(), 0)
                - transaction.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException("There are not enough "
                    + transaction.getFruit()
                    + " in the fruit storage!");
        }
        fruitStorage.put(transaction.getFruit(), quantity);
    }
}
