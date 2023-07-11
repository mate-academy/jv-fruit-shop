package core.basesyntax.service.strategy;

import core.basesyntax.service.operation.Handler;

public interface ActionStrategy {
    public Handler get(String action);
}
