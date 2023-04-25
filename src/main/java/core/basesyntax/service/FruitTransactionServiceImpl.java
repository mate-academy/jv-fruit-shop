package core.basesyntax.service;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private FruitTransactionDao fruitTransactionDao;

    public FruitTransactionServiceImpl(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void createNewFruitTransaction(String nameFruit, int quantity) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setFruit(nameFruit);
        fruitTransaction.setQuantity(quantity);
        fruitTransactionDao.add(fruitTransaction);
    }
}
