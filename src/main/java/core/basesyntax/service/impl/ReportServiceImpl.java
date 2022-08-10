package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport(FruitDao fruitDao) {
        StringBuilder builder = new StringBuilder();
        for (var entry : fruitDao.getFromStorage().entrySet()) {
            builder.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
