package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activity.ActivityHandler;
import core.basesyntax.strategy.ActivityStrategy;
import java.util.List;

public class FruitService {

    private ActivityStrategy activityStrategy;

    public FruitService(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    public void makeReport(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            ActivityHandler activityHandler = activityStrategy.get(fruitTransaction.getOperation());
            activityHandler.operate(fruitTransaction);
        }
    }
}
