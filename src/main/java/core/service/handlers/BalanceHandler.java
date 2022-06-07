package core.service.handlers;

import core.dao.FruitDao;
import core.dao.FruitDaoImpl;

public class BalanceHandler implements FruitOperationHandler {
    @Override
    public void doOperation(String fruitName, int fruitsQuantity) {
        FruitDao fruitDao = new FruitDaoImpl();
        fruitDao.update(fruitName,fruitsQuantity);
    }
}
