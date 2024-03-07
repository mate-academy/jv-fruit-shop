package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    CodeService getCodeService(FruitTransaction.Operation code);
}
