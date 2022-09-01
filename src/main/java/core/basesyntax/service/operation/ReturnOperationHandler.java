package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int amountFromStorage = fruitDao.getFruitAmount(fruitTransaction.getFruit());
        fruitDao.add(fruitTransaction.getFruit(),
                amountFromStorage + fruitTransaction.getAmount());
    }
}
