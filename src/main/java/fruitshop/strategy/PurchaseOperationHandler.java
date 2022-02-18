package fruitshop.strategy;

import fruitshop.dao.FruitDao;
import fruitshop.dao.FruitDaoImpl;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void updateAmountOfFruit(String fruitName, int quantity) {
        FruitDao fruitDao = new FruitDaoImpl();
        fruitDao.subtractValue(fruitName, quantity);
    }
}
