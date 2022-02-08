package shop.service.operations;

import dao.FruitDao;
import dao.FruitDaoImpl;
import shop.item.Fruit;

public class Supply implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(Fruit fruit) {
        if (fruitDao.get(fruit) != null) {
            fruit.setQuality(fruit.getQuality() + fruitDao.get(fruit).getQuality());
            fruitDao.update(fruit);
        } else {
            new FruitDaoImpl().add(fruit);
        }
    }
}
