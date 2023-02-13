package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.WarehouseDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private WarehouseDao warehouseDao;

    public PurchaseOperationHandler(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentFruitQuantity = warehouseDao.getQuantity(transaction.getFruit());
        int newFruitQuantity = currentFruitQuantity - transaction.getQuantity();
        String fruit = transaction.getFruit();
        if (currentFruitQuantity >= transaction.getQuantity()) {
            warehouseDao.setQuantity(fruit, newFruitQuantity);
        } else {
            throw new RuntimeException(transaction.getQuantity()
                    + " "
                    + transaction.getFruit()
                    + " required, but only "
                    + warehouseDao.getQuantity(transaction.getFruit())
                    + " available, operation not possible");
        }
    }
}
