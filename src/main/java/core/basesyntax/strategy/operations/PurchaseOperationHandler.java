package core.basesyntax.strategy.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        processIfPresent(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    private void processIfPresent(String name, int quantity) {
        if (Storage.fruits.containsKey(name) && Storage.fruits.get(name) >= quantity) {
            Storage.fruits.put(name, Storage.fruits.get(name) - quantity);
        } else {
            throw new RuntimeException("Not enough " + name + " fruit");
        }
    }
}
