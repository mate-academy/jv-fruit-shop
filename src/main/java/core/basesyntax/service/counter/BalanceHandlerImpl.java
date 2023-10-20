package core.basesyntax.service.counter;

import core.basesyntax.dao.Storage;
import core.basesyntax.service.transaction.FruitTransaction;

public class BalanceHandlerImpl implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.getFruitTypesAndQuantity().put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
