package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    private FruitDao fruitDao;

    public SupplyHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        if (fruitDao.contains(fruit)) {
            fruitDao.addFruit(fruit,
                    fruitDao.getQuantity(fruit) + transaction.getQuantity());
        } else {
            fruitDao.addFruit(fruit, transaction.getQuantity());
        }
    }
}
