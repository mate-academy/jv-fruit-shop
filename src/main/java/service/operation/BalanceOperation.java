package service.operation;

import dao.FruitDao;
import model.Fruit;

public class BalanceOperation implements OperationHandler {
    private FruitDao fruitDao;

    public BalanceOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public Fruit operate(Fruit fruit) {
        return fruitDao.add(fruit);
    }
}
