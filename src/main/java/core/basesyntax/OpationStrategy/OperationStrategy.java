package core.basesyntax.OpationStrategy;


import core.basesyntax.Operations.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
