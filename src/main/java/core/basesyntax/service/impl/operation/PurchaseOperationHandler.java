package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.WarehouseDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    private final Map<String, Integer> warehouse = new WarehouseDaoImpl().getWarehouse();

    @Override
    public void handle(FruitTransaction transaction) {
        int warehouseHasCodeBeforeCalculation = warehouse.hashCode();
        warehouse.entrySet().stream()
                .filter(e -> e.getKey().equals(transaction.getFruit()))
                .filter(e -> e.getValue() >= transaction.getQuantity())
                .forEach(e -> e.setValue(e.getValue() - transaction.getQuantity()));
        if (warehouseHasCodeBeforeCalculation == warehouse.hashCode()) {
            throw new RuntimeException(transaction.getQuantity()
                    + " "
                    + transaction.getFruit()
                    + " required, only "
                    + warehouse.get(transaction.getFruit())
                    + " available, operation not possible");
        }
    }
}
