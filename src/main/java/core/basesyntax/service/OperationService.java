package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activity.ActivityHandler;
import core.basesyntax.strategy.ActivityStrategy;
import java.util.List;

public class OperationService {
    private ActivityStrategy activityStrategy;
    private FruitDao fruitDao;

    public OperationService(ActivityStrategy activityStrategy, FruitDao fruitDao) {
        this.activityStrategy = activityStrategy;
        this.fruitDao = fruitDao;
    }

    public void executeOperations(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            ActivityHandler activityHandler = activityStrategy.get(fruitTransaction.getOperation());
            activityHandler.operate(fruitTransaction, fruitDao);
        }
    }
}
