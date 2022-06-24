package strategy.handler;

import db.Dao;
import db.DaoImpl;
import service.Handler;

public class SupplyHandler implements Handler {
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
