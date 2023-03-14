package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.service.impl.FruitTransaction;

public class BalanceOperationStrategy implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        Storage.getFruitShop().put(transaction.getFruit(), transaction.getQuantity());
    }
}
