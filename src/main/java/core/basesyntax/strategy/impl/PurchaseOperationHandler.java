package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void doCalculation(FruitTransaction fruitTransaction) {
        if (!Storage.dataStorage.containsKey(fruitTransaction.getFruit())
                || Storage.dataStorage.get(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity is negative for fruit: "
                    + fruitTransaction.getFruit());
        } else {
            int newQuantity = Storage.dataStorage.get(fruitTransaction.getFruit())
                    - fruitTransaction.getQuantity();
            Storage.dataStorage.put(fruitTransaction.getFruit(), newQuantity);
        }
    }
}
