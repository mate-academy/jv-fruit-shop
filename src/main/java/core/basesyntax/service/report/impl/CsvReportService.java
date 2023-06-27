package core.basesyntax.service.report.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.report.ReportService;
import java.util.stream.Collectors;

public class CsvReportService implements ReportService {
    private static final String REPORT_FIRST_LINE = "fruit,quantity";

    private final FruitDao fruitDao;

    public CsvReportService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String generateReport() {
        String fruitsInfo = fruitDao.getFruits().entrySet().stream()
                .map(e -> String.format("%s,%d", e.getKey(), e.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));
        return String.format("%s%n%s", REPORT_FIRST_LINE, fruitsInfo);
    }
}
