package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.TransactionStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitStorageService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitStorageServiceImpl implements FruitStorageService {
    private FruitStorageDao fruitStorageDao;
    private TransactionStorageDao transactionStorageDao;
    private OperationStrategy operationStrategy;

    public FruitStorageServiceImpl(FruitStorageDao fruitStorageDao,
                                   TransactionStorageDao transactionStorageDao,
                                   OperationStrategy operationStrategy) {
        this.fruitStorageDao = fruitStorageDao;
        this.transactionStorageDao = transactionStorageDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void update() {
        List<FruitTransaction> transactionList = transactionStorageDao.getAllAsList();
        for (FruitTransaction fruitTransaction : transactionList) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .updateFruitStorage(fruitTransaction, fruitStorageDao);
        }
    }
}
