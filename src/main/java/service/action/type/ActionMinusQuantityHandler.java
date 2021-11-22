package service.action.type;

import dao.FruitDaoImpl;
import model.Fruit;
import service.action.ActionStrategyHandler;

public class ActionMinusQuantityHandler extends ActionStrategyHandler {

    @Override
    public boolean doing(String fruitName, int quantity) {
        final FruitDaoImpl fruitDao = new FruitDaoImpl();
        Fruit fruit = fruitDao.getByName(fruitName);
        if (fruit == null) {
            Fruit newFruit = new Fruit(fruitName, quantity);
            fruitDao.add(newFruit);
            return true;
        } else if (fruit.getCount() < quantity) {
            throw new RuntimeException("the quantity of goods cannot be negative");
        }
        fruit.setCount(fruit.getCount() - quantity);
        return true;
    }
}
