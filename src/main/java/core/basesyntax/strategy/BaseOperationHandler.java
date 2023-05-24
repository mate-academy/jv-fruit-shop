package core.basesyntax.strategy;

import core.basesyntax.validation.IntValidator;
import core.basesyntax.validation.StrategyValidator;

public abstract class BaseOperationHandler implements OperationHandler {
    protected final IntValidator validator = new StrategyValidator();
}
