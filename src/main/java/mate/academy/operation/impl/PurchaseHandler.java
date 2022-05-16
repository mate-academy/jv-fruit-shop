package mate.academy.operation.impl;

import mate.academy.dao.FruitDaoImpl;
import mate.academy.model.Fruit;
import mate.academy.operation.OperationHandler;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void getHandler(Fruit fruit) {
        FruitDaoImpl fruitDao = new FruitDaoImpl();
        Fruit fruitInDB = fruitDao.get(fruit.getFruit());
        if (fruitInDB == null || fruitInDB.getQuantity() - fruit.getQuantity() < 0) {
            throw new RuntimeException(fruit.getFruit() + " quantity is not enough");
        }
        fruitInDB.setQuantity(fruitInDB.getQuantity() - fruit.getQuantity());
        fruitDao.add(fruitInDB);
    }
}
