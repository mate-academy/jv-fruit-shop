package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void toProcess(FruitTransaction transaction) {
        Storage.fruitStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
