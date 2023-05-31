package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.strategy.TransactionStrategy;

public class ProcessDataServiceImpl implements ProcessDataService {
    private final FruitTransactionDao transactionDao;

    public ProcessDataServiceImpl() {
        transactionDao = new FruitTransactionDaoImpl();
    }

    @Override
    public void processTransactions(TransactionStrategy transactionStrategy) {
        for (FruitTransaction transaction : transactionDao.getAll()) {
            transactionStrategy.get(transaction.getOperation()).handleTransaction(transaction);
        }
    }
}
