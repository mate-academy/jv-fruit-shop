package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEAD = "fruit,quantity";
    private static final String REPORT_DATA_DELIMITER = ",";
    private final FruitDao fruitDao;

    public ReportGeneratorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        return REPORT_HEAD + System.lineSeparator() + getReportData();
    }

    private String getReportData() {
        return fruitDao.getAll().stream()
                .map(fruit -> fruit.getName() + REPORT_DATA_DELIMITER + fruit.getQuantity())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
