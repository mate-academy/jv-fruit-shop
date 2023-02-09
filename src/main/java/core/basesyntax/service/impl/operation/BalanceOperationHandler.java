package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.WarehouseDao;
import core.basesyntax.dao.WarehouseDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final WarehouseDao warehouseDao = new WarehouseDaoImpl();

    @Override
    public void handle(FruitTransaction transaction) {
        warehouseDao.addLeftovers(transaction.getFruit(), transaction.getQuantity());
    }
}
