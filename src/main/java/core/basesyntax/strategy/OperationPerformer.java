package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationPerformer {
    void perform(FruitTransaction transaction);
}
