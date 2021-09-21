package core.basesyntax.operation;

import core.basesyntax.model.OperationType;

public interface OperationTypeStrategy {
    ShopOperationHandler get(OperationType type);
}
