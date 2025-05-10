package core.basesyntax.service.operation;

import core.basesyntax.checker.Validator;
import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public PurchaseOperation(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void recount(FruitTransaction transaction) {
        Validator.checkQuantity(transaction.getQuantity());
        int currentQuantity = fruitTransactionDao.getQuantity(transaction.getFruit());
        currentQuantity -= transaction.getQuantity();
        fruitTransactionDao.update(transaction.getFruit(), currentQuantity);
    }
}
