package core.basesyntax.strategy;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.operation_handlers.OperationHandler;

public interface OperationStrategy {
  OperationHandler get(FruitTransaction.Operation operation);
}
