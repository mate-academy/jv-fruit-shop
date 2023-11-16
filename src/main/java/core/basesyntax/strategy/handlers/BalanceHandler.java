package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.InventoryDao;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final InventoryDao inventoryDao;

    public BalanceHandler(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @Override
    public void processTransaction(String fruitName, int amount) {
        inventoryDao.putToInventory(fruitName, amount);
    }
}
