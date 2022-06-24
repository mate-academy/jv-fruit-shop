package core.basesyntax.strategy.handler;

import core.basesyntax.db.Dao;
import core.basesyntax.db.DaoImpl;
import core.basesyntax.service.TransactionHandler;

public class ReturnHandler implements TransactionHandler {
    @Override
    public boolean updateStorage(String fruitName, int quantity) {
        Dao dao = new DaoImpl();
        if (!dao.isFruitPresent(fruitName)) {
            dao.addEntry(fruitName, quantity);
        }
        int currentQuantity = dao.getFruitQuantity(fruitName);
        dao.addEntry(fruitName, currentQuantity + quantity);
        return true;
    }
}
