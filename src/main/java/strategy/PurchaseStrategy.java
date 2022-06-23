package strategy;

import db.Dao;
import db.DaoImpl;
import service.Strategy;

public class PurchaseStrategy implements Strategy {

    @Override
    public boolean updateStorage(String fruitName, int quantity) {
        Dao dao = new DaoImpl();
        if (!dao.isFruitPresent(fruitName)) {
            throw new RuntimeException(fruitName + " doesn't exist in the storage");
        }
        int currentQuantity = dao.getFruitQuantity(fruitName);
        if (currentQuantity < quantity) {
            throw new RuntimeException(quantity + " " + fruitName + "s is not available");
        }
        int newQuantity = currentQuantity - quantity;
        dao.addEntry(fruitName, newQuantity);
        if (newQuantity == 0) {
            dao.removeEntry(fruitName, newQuantity);
        }
        return true;
    }
}
