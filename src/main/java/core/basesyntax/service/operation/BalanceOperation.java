package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void updateStorage(FruitTransaction transaction) {
        FruitStorage.fruitStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
