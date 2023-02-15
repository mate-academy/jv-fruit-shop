package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final int DEFAULT_EMPTY_VALUE = 0;
    private final OperationStrategy operationStrategy;
    private final FruitStorageDao fruitStorageDao;

    public TransactionServiceImpl(OperationStrategy operationStrategy,
                                  FruitStorageDao fruitStorageDao) {
        this.operationStrategy = operationStrategy;
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void transaction(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            OperationHandler operation = operationStrategy.getOperation(transaction.getOperation());
            if (fruitStorageDao.get(transaction.getFruit()) == null) {
                fruitStorageDao
                        .add(transaction.getFruit(), operation
                                .operate(DEFAULT_EMPTY_VALUE, transaction.getQuantity()));
            }
            fruitStorageDao
                    .add(transaction.getFruit(), operation
                            .operate(fruitStorageDao.get(transaction.getFruit()),
                                    transaction.getQuantity()));
        }
    }
}
