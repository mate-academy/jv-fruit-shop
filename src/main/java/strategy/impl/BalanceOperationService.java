package strategy.impl;

import dao.FruitDao;
import model.Fruit;
import strategy.OperationService;

public class BalanceOperationService implements OperationService {
    private final FruitDao fruitDao;

    public BalanceOperationService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruitName, int quantity) {
        Fruit fruit = new Fruit(fruitName, quantity);
        fruit.setSold(0);
        fruitDao.add(fruit);
    }
}
