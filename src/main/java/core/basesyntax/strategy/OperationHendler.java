package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHendler {
    void operateTransaction(FruitTransaction transaction);
}
