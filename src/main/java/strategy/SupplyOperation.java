package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int amountOfSupply = transaction.getQuantity();

        int current = Storage.storage.getOrDefault(fruit, 0);
        Storage.storage.put(fruit, current + amountOfSupply);
    }
}
