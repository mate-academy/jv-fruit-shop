package service.action.type;

import dao.FruitDaoImpl;
import model.Fruit;
import service.action.ActionStrategyHandler;

public class ActionPlusQuantityHandler extends ActionStrategyHandler {

    @Override
    public boolean doing(String fruitName, int quantity) {
        final FruitDaoImpl fruitDao = new FruitDaoImpl();
        Fruit fruit = fruitDao.getByName(fruitName);
        if (fruit == null) {
            Fruit newFruit = new Fruit(fruitName, quantity);
            fruitDao.add(newFruit);
            return true;
        }
        fruit.setCount(fruit.getCount() + quantity);
        return true;
    }
}
