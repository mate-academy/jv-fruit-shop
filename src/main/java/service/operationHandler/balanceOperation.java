package service.operationHandler;

import dao.FruitDao;
import model.Fruit;

public class balanceOperation implements OperationHandler{
    private FruitDao fruitDao;
    @Override
    public Fruit typeOperation(Fruit fruit) {
        return fruitDao.add(fruit);
    }
}
