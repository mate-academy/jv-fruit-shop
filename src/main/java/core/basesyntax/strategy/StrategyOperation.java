package core.basesyntax.strategy;

import core.basesyntax.service.operation.Handler;

public interface StrategyOperation {
    public Handler get(String operation);
}
