package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoIml;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    private FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoIml();

    @Override
    public void Operation(FruitTransaction fruitTransaction) {
        FruitTransaction getFt = fruitTransactionDao.get(fruitTransaction.getFruit());
        int fruitQuantity = getFt.getQuantity() + fruitTransaction.getQuantity();
        getFt.setQuantity(fruitQuantity);
        fruitTransactionDao.update(getFt);
    }
}
