package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.handler.OperationHandler;

public interface FruitWorkStrategy {
    OperationHandler get(Operation key);
}
