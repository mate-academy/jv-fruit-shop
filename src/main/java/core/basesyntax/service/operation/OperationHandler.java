package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    Integer calculateNewAmount(Fruit fruit, Integer amount);
}
