package core.basesyntax.stretegy.handlers;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.Warehouse;

public class OperationReturn implements OperationHandler {
    @Override
    public int warehouseOperation(String fruit, int qte, Warehouse warehouse) {
        Integer rest = warehouse.getRemains().get(fruit);
        if (rest == null) {
            rest = 0;
        }
        warehouse.getDayOperations().add(new FruitTransaction(
                FruitTransaction.Operation.RETURN, fruit, qte));
        warehouse.getRemains().put(fruit, rest + qte);
        return warehouse.getRemains().get(fruit);
    }
}
