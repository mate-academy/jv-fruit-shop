package core.basesyntax.service.amount;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceActivityHandler implements ActivityHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public BalanceActivityHandler(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void setAmountOfFruit(FruitTransaction fruitTransaction) {
        fruitTransactionDao.addToStorage(fruitTransaction);
    }
}
