package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitsServiceImpl implements FruitsService {
    private static final String TITLE_FOR_REPORT = "fruit,quantity";
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;

    public FruitsServiceImpl(FruitDao fruitDao,
                             OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public String generateFruitsReport(List<FruitTransaction> fruitTransactionList) {
        fruitTransactionList.forEach(f -> operationStrategy.getOperation(f.getOperation())
                        .updateFruitsQuantity(f));
        Map<String, Integer> fruits = fruitDao.getStorageData();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE_FOR_REPORT).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : fruits.entrySet()) {
            reportBuilder.append(fruit.getKey()).append(",").append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
