package core.basesyntax.sevrice.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.sevrice.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private static final String DELIMITER = ",";
    private static final String NEW_FIRST_LINE = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportCreatorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(NEW_FIRST_LINE);
        fruitDao.getAll().forEach(((fruit, quantity)
                -> report.append(System.lineSeparator())
                .append(fruit.getName())
                .append(DELIMITER)
                .append(quantity)));
        return report.toString();
    }
}
