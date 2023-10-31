package core.basesyntax.service.performer;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionPerformerImpl implements TransactionPerformer {
    private OperationStrategy operationStrategy;
    private FruitStorageDao fruitStorageDao;

    public TransactionPerformerImpl(OperationStrategy operationStrategy,
                                    FruitStorageDao fruitStorageDao) {
        this.operationStrategy = operationStrategy;
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void performTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            operationStrategy.handleOperation(fruitTransaction, fruitStorageDao);
        }
    }
}
