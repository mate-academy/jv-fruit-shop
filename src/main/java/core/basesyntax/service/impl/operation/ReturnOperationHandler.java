package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.WarehouseDao;
import core.basesyntax.dao.WarehouseDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final WarehouseDao warehouseDao = new WarehouseDaoImpl();

    @Override
    public void handle(FruitTransaction transaction) {
        String fruitFromDb = warehouseDao.getFruitFromDb(transaction.getFruit());
        int quantityFromDb = warehouseDao.getQuantity(transaction.getFruit());
        if (fruitFromDb == null) {
            warehouseDao.updateQuantity(transaction.getFruit(), transaction.getQuantity());
        } else {
            warehouseDao.updateQuantity(fruitFromDb, quantityFromDb + transaction.getQuantity());
        }
    }
}

