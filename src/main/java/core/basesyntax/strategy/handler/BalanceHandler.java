package core.basesyntax.strategy.handler;

import core.basesyntax.db.Dao;
import core.basesyntax.db.DaoImpl;
import core.basesyntax.service.TransactionHandler;

public class BalanceHandler implements TransactionHandler {
    @Override
    public boolean updateStorage(String fruitName, int quantity) {
        Dao dao = new DaoImpl();
        if (dao.isFruitPresent(fruitName)) {
            throw new RuntimeException(fruitName + " already exists in the storage");
        }
        dao.addEntry(fruitName, quantity);
        return true;
    }
}
