package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandler;

public class SupplyFruitHandlerImpl implements FruitHandler {
    @Override
    public void doAction(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer oldQuantity = Storage.getFruitStorage().get(fruit);
        int newQuantity = oldQuantity + fruitTransaction.getQuantity();
        Storage.getFruitStorage().put(fruit, newQuantity);
    }
}
