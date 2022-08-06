package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    private FruitDao fruitDao;

    public ReturnHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        fruitDao.addFruit(fruit,
                fruitDao.getQuantity(fruit) + transaction.getQuantity());
    }
}
