package core.basesyntax.service.amount;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseActivityHandler implements ActivityHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public PurchaseActivityHandler(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void setAmountOfFruit(FruitTransaction fruitTransaction) {
        fruitTransactionDao.getFromStorage(fruitTransaction)
                .subtract(fruitTransaction.getQuantity());
    }
}
