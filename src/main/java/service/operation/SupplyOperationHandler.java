package service.operation;

import dao.FruitDao;
import model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitDao supplyFruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        supplyFruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruit) {
        supplyFruitDao.setFruitQuantity(fruit.getFruitName(),
                supplyFruitDao.getFruitQuantity(fruit.getFruitName())
                        + fruit.getFruitQuantity());
    }
}
