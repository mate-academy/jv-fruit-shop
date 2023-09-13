package service.operation;

import dao.FruitDao;
import model.Fruit;

public class ReturnOperation implements OperationHandler {
    private FruitDao fruitDao;

    public ReturnOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public Fruit operate(Fruit fruit) {
        fruitDao.get(fruit).setQuantity(fruitDao.get(fruit).getQuantity() + fruit.getQuantity());
        return fruitDao.get(fruit);
    }
}
