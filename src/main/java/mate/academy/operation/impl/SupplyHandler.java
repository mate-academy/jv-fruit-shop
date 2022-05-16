package mate.academy.operation.impl;

import mate.academy.dao.FruitDaoImpl;
import mate.academy.model.Fruit;
import mate.academy.operation.OperationHandler;

public class SupplyHandler implements OperationHandler {

    @Override
    public void getHandler(Fruit fruit) {
        FruitDaoImpl fruitDao = new FruitDaoImpl();
        Fruit fruitInDB = fruitDao.get(fruit.getFruit());
        if (fruitInDB == null) {
            fruitDao.add(fruit);
        } else {
            fruitInDB.setQuantity(fruitInDB.getQuantity() + fruit.getQuantity());
            fruitDao.add(fruitInDB);
        }
    }
}
