package core.basesyntax.service;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.operation.ShopOperationHandler;

public interface OperationTypeStrategy {
    ShopOperationHandler get(OperationType type);
}
