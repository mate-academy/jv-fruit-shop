package core.basesyntax.stratagy;

import core.basesyntax.model.FruitTransaction;

public interface OperationPerformerStrategy {
    public OperationPerformer getOperationPerformer(FruitTransaction.Operation operation);
}
