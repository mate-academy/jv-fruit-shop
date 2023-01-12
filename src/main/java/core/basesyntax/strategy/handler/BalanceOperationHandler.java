package core.basesyntax.strategy.handler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        FruitStorage.getStorage().put(transaction.getFruit(), transaction.getQuantity());
    }
}
