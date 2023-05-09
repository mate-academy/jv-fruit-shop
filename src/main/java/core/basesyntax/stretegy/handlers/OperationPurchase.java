package core.basesyntax.stretegy.handlers;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.Warehouse;

import java.util.NoSuchElementException;

public class OperationPurchase implements OperationHandler {
    @Override
    public int warehouseOperation(String fruit, int qte, Warehouse warehouse) {
        Integer rest = warehouse.getRemains().get(fruit);
        if (rest == null || rest < qte) {
            throw new NoSuchElementException("Not enough quantity of " + fruit + " on the rest");
        }
        warehouse.getDayOperations().add(new FruitTransaction(
                FruitTransaction.Operation.PURCHASE, fruit, qte));
        warehouse.getRemains().put(fruit, rest - qte);
        return warehouse.getRemains().get(fruit);

    }
}
