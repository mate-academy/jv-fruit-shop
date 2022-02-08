package shop.service.operations;

import dao.FruitDao;
import dao.FruitDaoImpl;
import shop.item.Fruit;

public class Return implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(Fruit fruit) {
        fruit.setQuality(fruitDao.get(fruit).getQuality() + fruit.getQuality());
        fruitDao.update(fruit);
    }
}
