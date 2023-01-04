package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public FruitsTranslation getOperationResult(FruitsTranslation fruitTransaction) {
        return fruitTransaction;
    }
}
