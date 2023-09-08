package service.action.type;

import dao.FruitDaoImpl;
import model.Fruit;
import service.action.ActionStrategyHandler;

public class MinusQuantityHandler implements ActionStrategyHandler {
    private final FruitDaoImpl fruitDao;

    public MinusQuantityHandler() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public boolean doing(String fruitName, int quantity) {
        Fruit fruit = fruitDao.get(fruitName).orElseThrow(() ->
                new RuntimeException("there is no such vegetable to sell"));
        if (fruit.getCount() < quantity) {
            throw new RuntimeException("the quantity of goods cannot be negative");
        }
        fruit.setCount(fruit.getCount() - quantity);
        return true;
    }
}
