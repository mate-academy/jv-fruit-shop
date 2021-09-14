package shop.service.operations;

import dao.FruitDao;
import dao.FruitDaoImpl;
import shop.item.Fruit;

public class Balance implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(Fruit fruit) {
        fruitDao.add(fruit);
    }
}
