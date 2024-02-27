package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activity.ActivityHandler;
import core.basesyntax.strategy.ActivityStrategy;
import java.util.List;

public class ReportService {
    private ActivityStrategy activityStrategy;
    private FruitDao fruitDao;

    public ReportService(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
        fruitDao = new FruitDaoImpl();
    }

    public void executeOperations(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            ActivityHandler activityHandler = activityStrategy.get(fruitTransaction.getOperation());
            activityHandler.operate(fruitTransaction);
        }
    }

    public String generateReport() {
        return fruitDao.createReport();
    }
}
