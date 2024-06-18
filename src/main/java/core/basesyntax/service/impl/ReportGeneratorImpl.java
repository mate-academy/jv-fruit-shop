package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String reportHead = "fruit,quantity";
    private static final String reportDataDelimiter = ",";
    private final FruitDao fruitDao;

    public ReportGeneratorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        return reportHead + System.lineSeparator() + getReportData();
    }

    private String getReportData() {
        return fruitDao.getAll().stream()
                .map(fruit -> fruit.getName() + reportDataDelimiter + fruit.getQuantity())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
