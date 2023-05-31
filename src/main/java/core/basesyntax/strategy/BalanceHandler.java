package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class BalanceHandler implements OperationHandler {
    @Override
    public void toStorage(FruitTransaction transaction) {
        Storage.fruitInventory.put(transaction.getFruit(), transaction.getQuantity());
    }
}
