package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyTransactionHandler implements TransactionHandler {
    private FruitDao fruitDao;

    public SupplyTransactionHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        Integer balance = fruitDao.add(fruitTransaction.getFruitName(),
                fruitTransaction.getQuantity());
        if (balance < 0) {
            throw new RuntimeException("Balance is negative after activity in class "
                    + this.getClass().getSimpleName());
        }
    }
}
