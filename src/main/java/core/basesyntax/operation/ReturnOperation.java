package core.basesyntax.operation;

import core.basesyntax.db.FruitDao;
import core.basesyntax.transaction.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        InputValidator.unexpectedNullOrEmptyFields(fruitTransaction);
        String fruitName = fruitTransaction.getFruitName();
        Integer fruitQuantity = fruitDao.getFruitQuantity(fruitName);
        int fruitTransitionQuantity = fruitTransaction.getQuantity();
        int updatedQuantity = fruitQuantity + fruitTransitionQuantity;
        fruitDao.saveOrUpdate(fruitName, updatedQuantity);
    }
}
