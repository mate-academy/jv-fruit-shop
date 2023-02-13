package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.WarehouseDao;
import core.basesyntax.dao.WarehouseDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final WarehouseDao warehouseDao = new WarehouseDaoImpl();

    @Override
    public void handle(FruitTransaction transaction) {
        int quantityFromDb = warehouseDao.getQuantity(transaction.getFruit());
        String fruit = transaction.getFruit();
        if (warehouseDao.isPresent(fruit)) {
            warehouseDao.setQuantity(fruit, quantityFromDb + transaction.getQuantity());
        } else {
            warehouseDao.setQuantity(fruit, transaction.getQuantity());
        }
    }
}
