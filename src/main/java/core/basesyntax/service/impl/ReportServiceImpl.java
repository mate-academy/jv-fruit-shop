package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportService;
import java.util.Map;

public record ReportServiceImpl(FruitDao fruitDao) implements
        ReportService {

    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        Map<String, Integer> storage = fruitDao.getStorage();
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(entry.getKey()).append(SEPARATOR)
                .append(entry.getValue())
                .append(System.lineSeparator());
        }
        return report.toString();
    }
}
