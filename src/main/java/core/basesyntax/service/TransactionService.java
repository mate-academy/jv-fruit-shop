package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activity.TransactionHandler;
import core.basesyntax.strategy.ActivityStrategy;
import java.util.List;

public class TransactionService {
    private ActivityStrategy activityStrategy;
    private FruitDao fruitDao;

    public TransactionService(ActivityStrategy activityStrategy, FruitDao fruitDao) {
        this.activityStrategy = activityStrategy;
        this.fruitDao = fruitDao;
    }

    public void executeTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            TransactionHandler transactionHandler = activityStrategy
                    .get(fruitTransaction.getOperation());
            transactionHandler.handleTransaction(fruitTransaction);
        }
    }
}
