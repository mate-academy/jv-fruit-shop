package core.basesyntax.strategy.service;

import core.basesyntax.model.FruitsTransaction;

public interface OperationHandler {
    void perform(FruitsTransaction fruitsTransaction);
}
