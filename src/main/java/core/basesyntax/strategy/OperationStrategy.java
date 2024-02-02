package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operations.OperationCompiler;

public interface OperationStrategy {
    OperationCompiler get(FruitTransaction.Operation operation);
}
