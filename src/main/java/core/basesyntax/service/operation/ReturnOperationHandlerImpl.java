package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandlerImpl implements OperationHandler {

    @Override
    public void operation(FruitTransaction fruitT, FruitTransactionDao fruitTDao) {
        FruitTransaction fruitTransactionFromDb = fruitTDao
                .get(fruitT.getFruit());
        FruitTransaction newFruitTransaction = fruitTransactionFromDb;
        newFruitTransaction.setQuantity(fruitTransactionFromDb.getQuantity()
                + fruitT.getQuantity());
        fruitTDao.update(newFruitTransaction);
    }
}
