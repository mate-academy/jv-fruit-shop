package core.strategy;

import core.db.Storage;
import core.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int current = Storage.get(fruit);
        int newCurrent = current + quantity;
        Storage.put(fruit, newCurrent);
    }
}
