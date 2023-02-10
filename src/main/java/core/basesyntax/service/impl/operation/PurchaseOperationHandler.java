package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.WarehouseDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    private final Map<String, Integer> warehouse = new WarehouseDaoImpl().getWarehouse();

    @Override
    public void handle(FruitTransaction transaction) {
        int currentFruitQuantity = warehouse.get(transaction.getFruit());
        int newFruitQuantity = currentFruitQuantity - transaction.getQuantity();
        String fruit = transaction.getFruit();
        if (currentFruitQuantity >= transaction.getQuantity()) {
            warehouse.put(fruit, newFruitQuantity);
        } else {
            throw new RuntimeException(transaction.getQuantity()
                    + " "
                    + transaction.getFruit()
                    + " required, but only "
                    + warehouse.get(transaction.getFruit())
                    + " available, operation not possible");
        }
    }
}
