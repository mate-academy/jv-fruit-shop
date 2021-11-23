package core.basesyntax.service.handler;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    Fruit apply(int fruitNumber, String fruitName);
}
