package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationActivity {
    void handleTransaction(FruitTransaction transaction);
}
