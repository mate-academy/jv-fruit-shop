package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final FruitTransactionDao transactionDao;

    public FruitTransactionServiceImpl(FruitTransactionDaoImpl transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public void add(FruitTransaction transaction) {
        transactionDao.add(transaction);
    }
}
