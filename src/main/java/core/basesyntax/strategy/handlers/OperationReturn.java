package core.basesyntax.strategy.handlers;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.Warehouse;

public class OperationReturn implements OperationHandler {
    @Override
    public int warehouseOperation(String fruit, int quantity, Warehouse warehouse) {
        int remainingQuantity = warehouse.getRemains().get(fruit);
        warehouse.getDayOperations().add(new FruitTransaction(
                FruitTransaction.Operation.RETURN, fruit, quantity));
        warehouse.getRemains().put(fruit, remainingQuantity + quantity);
        return warehouse.getRemains().get(fruit);
    }
}
