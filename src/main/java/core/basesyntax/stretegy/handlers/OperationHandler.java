package core.basesyntax.stretegy.handlers;

import core.basesyntax.service.Warehouse;

public interface OperationHandler {
    int warehouseOperation(String fruit, int qte, Warehouse warehouse);
}
