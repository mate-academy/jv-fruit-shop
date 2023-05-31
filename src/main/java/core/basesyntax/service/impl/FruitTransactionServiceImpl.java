package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final FruitTransactionDao fruitTransactionDao;

    public FruitTransactionServiceImpl() {
        fruitTransactionDao = new FruitTransactionDaoImpl();
    }

    @Override
    public void createFruitTransaction(String operationCode, String fruit, int quantity) {
        FruitTransaction transaction = FruitTransaction.of(operationCode, fruit, quantity);
        fruitTransactionDao.add(transaction);
    }
}
