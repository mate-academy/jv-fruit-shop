package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.InventoryDao;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final InventoryDao inventoryDao;

    public PurchaseHandler(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @Override
    public void processTransaction(String fruitName, int amount) {
        int newAmount = inventoryDao.getAmountByFruit(fruitName) - amount;
        inventoryDao.putToInventory(fruitName, newAmount);
    }

}
