package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public Fruit handle(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getName(), fruitTransaction);
        return fruitTransaction;
    }
}
