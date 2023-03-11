package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

@FunctionalInterface
public interface ReportStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
