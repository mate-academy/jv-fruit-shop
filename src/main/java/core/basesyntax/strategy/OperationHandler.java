package core.basesyntax.strategy;

import core.basesyntax.model.FruitsTranslation;

public interface OperationHandler {
    FruitsTranslation getOperationResult(FruitsTranslation fruitTransaction);
}
