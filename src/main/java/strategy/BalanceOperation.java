package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        Storage.storage.put(fruit, quantity);
    }
}
