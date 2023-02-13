package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.WarehouseDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private WarehouseDao warehouseDao;

    public BalanceOperationHandler(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        warehouseDao.setQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
