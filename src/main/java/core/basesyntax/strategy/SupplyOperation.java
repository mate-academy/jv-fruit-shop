package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int newQuantity = Storage.get(transaction.getFruit()) + transaction.getQuantity();
        Storage.put(transaction.getFruit(), newQuantity);
    }
}
