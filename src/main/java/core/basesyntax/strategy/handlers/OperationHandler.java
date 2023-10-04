package core.basesyntax.strategy.handlers;

import core.basesyntax.service.Warehouse;

public interface OperationHandler {
    int warehouseOperation(String fruit, int quantity, Warehouse warehouse);
}
