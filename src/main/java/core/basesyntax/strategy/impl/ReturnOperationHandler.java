package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void doCalculation(FruitTransaction fruitTransaction) {
        if (Storage.dataStorage.containsKey(fruitTransaction.getFruit())) {
            int newQuantity = Storage.dataStorage.get(fruitTransaction.getFruit())
                    + fruitTransaction.getQuantity();
            Storage.dataStorage.put(fruitTransaction.getFruit(), newQuantity);
        } else {
            Storage.dataStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
