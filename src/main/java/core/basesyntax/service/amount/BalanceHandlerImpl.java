package core.basesyntax.service.amount;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandlerImpl implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruitType(), fruitTransaction.getAmount());
    }
}
