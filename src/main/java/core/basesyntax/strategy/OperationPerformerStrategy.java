package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationPerformerStrategy {
    OperationPerformer getOperationPerformer(FruitTransaction.Operation operation);
}
