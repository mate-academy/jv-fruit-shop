package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String DELIMITER = ",";
    private static final String REPORT_FIRST_LINE = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportGeneratorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder(REPORT_FIRST_LINE);
        fruitDao.getAll().entrySet().stream()
                        .forEach(e -> report.append(e.getKey()).append(",")
                                .append(e.getValue()).append(System.lineSeparator()));
        return report.toString();
    }
}
