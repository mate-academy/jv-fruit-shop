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
        FruitTransaction fruit = fruitTransactionDao.getFromStorage(fruitTransaction);
        if (fruit.getQuantity() < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Cannot sell more fruit than is in stock");
        }
        fruit.subtract(fruitTransaction.getQuantity());
    }
}
