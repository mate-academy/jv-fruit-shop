package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int newQuantity = fruitTransaction.getQuantity();
        if (Storage.fruitsStorage.containsKey(fruitName)) {
            int oldQuantity = Storage.fruitsStorage.get(fruitName);
            Storage.fruitsStorage.put(fruitName, oldQuantity + newQuantity);
        } else {
            Storage.fruitsStorage.put(fruitName, newQuantity);
        }
    }
}
