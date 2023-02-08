package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.WarehouseDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    private final Map<String, Integer> warehouse = new WarehouseDaoImpl().getWarehouse();

    @Override
    public void getOperationResult(FruitTransaction transaction) {
        warehouse.entrySet().stream()
                .filter(e -> e.getKey().equals(transaction.getFruit()))
                .forEach(e -> e.setValue(e.getValue() + transaction.getQuantity()));
    }
}
