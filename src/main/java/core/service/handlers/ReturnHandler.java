package core.service.handlers;

import core.dao.FruitDao;
import core.dao.FruitDaoImpl;

public class ReturnHandler implements FruitOperationHandler {
    @Override
    public void doOperation(String fruitName, int fruitsQuantity) {
        FruitDao fruitDao = new FruitDaoImpl();
        int fruitsQuantityInStorage = fruitDao.get(fruitName);
        fruitsQuantityInStorage += fruitsQuantity;
        fruitDao.update(fruitName,fruitsQuantityInStorage);
    }
}
