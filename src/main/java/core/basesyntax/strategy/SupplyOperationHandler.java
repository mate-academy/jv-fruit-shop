package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(String fruit, Integer quantity) {
        fruitDao.add(fruit, fruitDao.getQuantity(fruit) + quantity);
    }
}
