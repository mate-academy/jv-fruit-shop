package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperationService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.FruitTransactionStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final FruitTransactionDao transactionDao;
    private final FruitTransactionStrategy fruitTransactionStrategy;

    public FruitTransactionServiceImpl(FruitTransactionDao transactionDao) {
        this.transactionDao = transactionDao;
        fruitTransactionStrategy = new FruitTransactionStrategy();
    }

    @Override
    public void add(FruitTransaction transaction) {
        transactionDao.add(transaction);
        String fruitName = transaction.getFruit().getName();
        int value = transaction.getQuantity();
        int prevValue = Storage.fruitMap.getOrDefault(fruitName, 0);

        FruitOperationService fruitOperationService = fruitTransactionStrategy
            .getFruitOperationService(transaction.getOperation());

        int result = fruitOperationService.performOperation(prevValue, value);
        transactionDao.putFruitIntoMap(fruitName, result);
    }
}
