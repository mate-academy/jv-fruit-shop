package service.action.type;

import bd.LocalStorage;
import dao.FruitDaoImpl;
import model.Fruit;
import service.action.ActionStrategyHandler;

public class PlusQuantityHandler implements ActionStrategyHandler {
    private final FruitDaoImpl fruitDao;

    public PlusQuantityHandler() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public boolean doing(String fruitName, int quantity) {
        Fruit fruit = fruitDao.get(fruitName).orElseGet(() -> {
            Fruit fruit1 = new Fruit(fruitName, 0);
            LocalStorage.fruits.add(fruit1);
            return fruit1;
        });
        fruit.setCount(fruit.getCount() + quantity);
        return true;
    }
}
