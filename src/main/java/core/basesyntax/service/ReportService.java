package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activity.ActivityHandler;
import core.basesyntax.strategy.ActivityStrategy;
import java.util.List;
import java.util.Map;

public class ReportService {
    private ActivityStrategy activityStrategy;
    private FruitDao fruitDao;

    public ReportService(ActivityStrategy activityStrategy, FruitDao fruitDao) {
        this.activityStrategy = activityStrategy;
        this.fruitDao = fruitDao;
    }

    public void executeOperations(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            ActivityHandler activityHandler = activityStrategy.get(fruitTransaction.getOperation());
            activityHandler.operate(fruitTransaction, fruitDao);
        }
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("type,fruit\n");
        for (Map.Entry<String, Integer> fruit : fruitDao.getFruits()) {
            report.append(fruit.getKey() + "," + fruit.getValue() + System.lineSeparator());
        }
        return report.toString();
    }
}
