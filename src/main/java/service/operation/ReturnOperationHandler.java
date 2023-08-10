package service.operation;

import dao.FruitDao;
import model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao returnFruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.returnFruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruit) {
        returnFruitDao.setFruitQuantity(fruit.getFruitName(),
                returnFruitDao.getFruitQuantity(fruit.getFruitName())
                        + fruit.getFruitQuantity());
    }
}
