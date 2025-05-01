package core.basesyntax.strategy.handlers;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class ReturnOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction, FruitStorage fruitStorage) {
        fruitStorage.supplyItem(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
