package strategy;

import core.basesyntax.FruitTransaction;
import db.Storage;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = Storage.fruitStorage.getOrDefault(transaction.getFruit(), 0);
        Storage.fruitStorage.put(transaction.getFruit(), currentQuantity
                + transaction.getQuantity());
    }
}
