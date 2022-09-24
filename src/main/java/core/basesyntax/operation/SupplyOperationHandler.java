package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.dao.FruitDao;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handler(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        if (fruitDao.contains(fruit)) {
            fruitDao.addFruit(fruit, fruitDao.getQuantity(fruit) + transaction.getQuantity());
        } else {
            fruitDao.addFruit(fruit, transaction.getQuantity());
        }
    }
}
