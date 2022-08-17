package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class AddingOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public AddingOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void processOperation(FruitTransaction transaction) {
        fruitDao.merge(transaction.getFruit(), transaction.getQuantity());
    }
}
