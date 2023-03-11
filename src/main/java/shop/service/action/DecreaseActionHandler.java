package shop.service.action;

import shop.dao.FruitDaoImpl;
import shop.model.Fruit;

public class DecreaseActionHandler implements ActionHandler {
    private final FruitDaoImpl fruitDao;

    public DecreaseActionHandler() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public boolean update(String fruitName, int count) {
        Fruit fruit = fruitDao.get(fruitName);
        if (fruit == null) {
            throw new RuntimeException("Storage don't have this fruit " + fruitName);
        }
        if (fruit.getCount() < count) {
            throw new RuntimeException("U can't sell to many, u have " + fruit.getCount());
        }
        fruit.setCount(fruit.getCount() - count);
        return true;
    }
}
