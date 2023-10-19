package core.basesyntax.service.amount;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyActivityHandler implements ActivityHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public SupplyActivityHandler(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void setAmountOfFruit(FruitTransaction fruitTransaction) {
        fruitTransactionDao.getFromStorage(fruitTransaction).add(fruitTransaction.getQuantity());
    }
}
