package strategy;

import db.Storage;
import model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = Storage.fruitsStorage.get(fruit);
        if (quantity > 0) {
            Storage.fruitsStorage.put(fruit, quantity + fruitTransaction.getQuantity());
        } else {
            Storage.fruitsStorage.put(fruit, fruitTransaction.getQuantity());
        }
    }
}
