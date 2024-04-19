package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    Integer calculateQuantity(Integer before, Integer after);
}
