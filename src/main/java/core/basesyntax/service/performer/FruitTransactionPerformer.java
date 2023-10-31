package core.basesyntax.service.performer;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;

public class FruitTransactionPerformer implements Performer {
    private final OperationStrategy operationStrategy;
    private final FruitTransactionDao fruitTransactionDao;

    public FruitTransactionPerformer(OperationStrategy operationStrategy,
                                     FruitTransactionDao fruitTransactionDao) {
        this.operationStrategy = operationStrategy;
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void performAll() {
        for (FruitTransaction transaction : fruitTransactionDao.getAll()) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.perform(transaction);
        }
    }
}
