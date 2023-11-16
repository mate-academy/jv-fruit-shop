package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.InventoryDao;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final InventoryDao inventoryDao;

    public ReturnHandler(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @Override
    public void processTransaction(String fruitName, int amount) {
        int newAmount = inventoryDao.getAmountByFruit(fruitName) + amount;
        inventoryDao.putToInventory(fruitName, newAmount);
    }
}
