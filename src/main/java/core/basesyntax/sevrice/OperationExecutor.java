package core.basesyntax.sevrice;

import core.basesyntax.model.FruitTransaction;

public interface OperationExecutor {
    void execute(FruitTransaction transaction);
}
