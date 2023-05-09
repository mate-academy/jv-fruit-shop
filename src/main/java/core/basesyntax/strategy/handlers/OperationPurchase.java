package core.basesyntax.strategy.handlers;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.Warehouse;
import java.util.NoSuchElementException;

public class OperationPurchase implements OperationHandler {
    @Override
    public int warehouseOperation(String fruit, int quantity, Warehouse warehouse) {
        Integer remainingQuantity = warehouse.getRemains().get(fruit);
        if (remainingQuantity == null || remainingQuantity < quantity) {
            throw new NoSuchElementException("Not enough quantity of " + fruit + " on the rest");
        }
        warehouse.getDayOperations().add(new FruitTransaction(
                FruitTransaction.Operation.PURCHASE, fruit, quantity));
        warehouse.getRemains().put(fruit, remainingQuantity - quantity);
        return warehouse.getRemains().get(fruit);

    }
}
