package strategy;

import db.Dao;
import db.DaoImpl;
import service.Strategy;

public class SupplyStrategy implements Strategy {

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
