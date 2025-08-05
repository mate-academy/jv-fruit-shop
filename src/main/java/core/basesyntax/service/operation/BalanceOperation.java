package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitShop;

public class BalanceOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        FruitShop.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
