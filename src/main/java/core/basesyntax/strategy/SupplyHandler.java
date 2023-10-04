package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public int executeOperation(FruitTransaction fruitTransaction) {
        int newQuantity = Storage.storage.get(fruitTransaction.getFruit())
                + fruitTransaction.getQuantity();
        Storage.storage.put(fruitTransaction.getFruit(), newQuantity);
        return newQuantity;
    }
}
