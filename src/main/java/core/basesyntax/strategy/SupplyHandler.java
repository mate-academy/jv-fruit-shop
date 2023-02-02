package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.models.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int newQuantity = fruitTransaction.getQuantity();
        if (Storage.fruits.containsKey(fruitName)) {
            int oldQuantity = Storage.fruits.get(fruitName);
            Storage.fruits.put(fruitName, oldQuantity + newQuantity);
        } else {
            Storage.fruits.put(fruitName, newQuantity);
        }
    }
}
