package core.basesyntax.strategy.handlers;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.Warehouse;

public class OperationBalance implements OperationHandler {
    @Override
    public int warehouseOperation(String fruit, int quantity, Warehouse warehouse) {
        warehouse.getDayOperations().add(new FruitTransaction(
                FruitTransaction.Operation.BALANCE, fruit, quantity));
        warehouse.getRemains().put(fruit, quantity);
        return warehouse.getRemains().get(fruit);
    }
}
