package core.basesyntax.service;

import core.basesyntax.strategy.OperationHandler;

public interface OperationStrategy {

    OperationHandler getOperationService(String letter);
}
