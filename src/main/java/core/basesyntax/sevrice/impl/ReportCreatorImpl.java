package core.basesyntax.sevrice.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.sevrice.ReportCreator;
import core.basesyntax.strategy.strategyimpl.OperationStrategyImpl;

public class ReportCreatorImpl implements ReportCreator {
    private static final String DELIMITER = ",";
    private final OperationStrategy operationExecutor = new OperationStrategyImpl();
    private final String newFirstLine = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportCreatorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(newFirstLine);
        fruitDao.getAll().forEach(((fruit, quantity)
                -> report.append(System.lineSeparator())
                .append(fruit.getName())
                .append(DELIMITER)
                .append(quantity)));
        return report.toString();
    }
}
