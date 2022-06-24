package strategy.handler;

import db.Dao;
import db.DaoImpl;
import service.Handler;

public class BalanceHandler implements Handler {
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
