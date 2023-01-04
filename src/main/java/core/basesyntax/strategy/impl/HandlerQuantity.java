package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.strategy.OperationHandler;

public class HandlerQuantity implements OperationHandler {
    @Override
    public FruitsTranslation getOperationResult(FruitsTranslation fruitTransaction) {
        int fruitQuantity = fruitTransaction.getQuantity();
        fruitTransaction.setQuantity(-fruitQuantity);
        return fruitTransaction;
    }
}
