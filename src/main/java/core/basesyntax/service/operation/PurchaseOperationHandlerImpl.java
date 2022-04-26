package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        FruitTransaction fruitTransactionFromDb = fruitTransactionDao
                .get(fruitTransaction.getFruit());
        FruitTransaction newFruitTransaction = fruitTransactionFromDb;
        newFruitTransaction.setQuantity(fruitTransactionFromDb.getQuantity()
                - fruitTransaction.getQuantity());
        fruitTransactionDao.update(newFruitTransaction);
    }
}
