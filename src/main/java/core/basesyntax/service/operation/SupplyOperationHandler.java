package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private FruitTransactionDao fruitTransactionDao;

    public SupplyOperationHandler(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        FruitTransaction newFruitTransaction = fruitTransactionDao
                .get(transaction.getFruit());
        newFruitTransaction.setQuantity(newFruitTransaction.getQuantity()
                + transaction.getQuantity());
        fruitTransactionDao.update(newFruitTransaction);
    }
}
