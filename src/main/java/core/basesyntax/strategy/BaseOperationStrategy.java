package core.basesyntax.strategy;

import core.basesyntax.validation.StrategyValidator;

public abstract class BaseOperationStrategy implements OperationStrategy {
    protected final StrategyValidator validator = new StrategyValidator();
}
