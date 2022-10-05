package core.basesyntax.sevrice.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.sevrice.OperationExecutor;
import core.basesyntax.sevrice.ReportMaker;

public class ReportMakerImpl implements ReportMaker {
    private static final String DELIMITER = ",";
    private final OperationExecutor operationExecutor = new OperationExecutorImpl();
    private final String newFirstLine = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportMakerImpl(FruitDao fruitDao) {
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
