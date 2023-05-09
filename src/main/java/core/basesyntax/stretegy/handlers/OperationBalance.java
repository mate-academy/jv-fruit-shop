package core.basesyntax.stretegy.handlers;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.Warehouse;

public class OperationBalance implements OperationHandler {
    @Override
    public int warehouseOperation(String fruit, int qte, Warehouse warehouse) {
        warehouse.getDayOperations().add(new FruitTransaction(
                FruitTransaction.Operation.BALANCE, fruit, qte));
        warehouse.getRemains().put(fruit, qte);
        return warehouse.getRemains().get(fruit);
    }
}
