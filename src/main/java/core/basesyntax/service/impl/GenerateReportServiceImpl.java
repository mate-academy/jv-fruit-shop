package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.GenerateReportService;
import java.util.Map;

public class GenerateReportServiceImpl implements GenerateReportService {
    private static final String COLUMN_FRUIT = "fruit";
    private static final String COLUMN_QUANTITY = "quantity";

    @Override
    public String generateReport(FruitDao fruitDao) {
        StringBuilder builder = new StringBuilder(COLUMN_FRUIT.concat(",")
                .concat(COLUMN_QUANTITY).concat(System.lineSeparator()));
        for (Map.Entry<String, Integer> pair : fruitDao.getAll().entrySet()) {
            builder.append(pair.getKey()).append(",")
                    .append(pair.getValue()).append(System.lineSeparator());
        }
        return builder.toString().strip();
    }
}
