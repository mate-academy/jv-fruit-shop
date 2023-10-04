package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;

public class PurchaseOperationHandler implements OperationHandler {
    private static final int ALLOWABLE_QUANTITY = 0;
    private final FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void calculate(String fruit, int value) {
        int newFruitsQuantity = fruitDao.getStorage().get(fruit) - value;
        if (newFruitsQuantity < ALLOWABLE_QUANTITY) {
            throw new RuntimeException("Purchase value can't be greater than fruits quantity");
        }
        fruitDao.add(fruit, newFruitsQuantity);
    }
}
