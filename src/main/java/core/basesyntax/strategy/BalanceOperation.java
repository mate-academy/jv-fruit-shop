package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.getStorage().put(transaction.getFruit(), transaction.getQuantity());
    }
}
