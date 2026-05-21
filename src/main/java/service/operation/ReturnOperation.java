package service.operation;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();

        int currentQuantity = Storage.fruitStorage.getOrDefault(fruit, 0);

        Storage.fruitStorage.put(fruit, currentQuantity + transaction.getQuantity());
    }
}
