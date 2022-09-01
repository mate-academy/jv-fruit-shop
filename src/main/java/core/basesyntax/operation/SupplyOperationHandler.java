package core.basesyntax.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        if (fruitDao.contains(fruit)) {
            fruitDao.addFruit(fruit, fruitDao.getQuantity(fruit) + transaction.getQuantity());
        } else {
            fruitDao.addFruit(fruit, transaction.getQuantity());
        }
    }
}
