package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class AddOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public AddOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.getAll().merge(
                fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(),
                Integer::sum);
    }
}
