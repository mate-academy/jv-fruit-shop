package core.basesyntax.strategy.handlers;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class BalanceOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction, FruitStorage fruitStorage) {
        fruitStorage.saveItem(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
