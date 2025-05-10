package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer valueBeforeReturn = FruitStorage.FRUITS.get(fruitTransaction.getFruit());
        Integer valueAfterReturn = valueBeforeReturn + fruitTransaction.getQuantity();
        FruitStorage.FRUITS.put(fruitTransaction.getFruit(),valueAfterReturn);
    }
}
