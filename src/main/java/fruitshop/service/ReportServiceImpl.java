package fruitshop.service;

import fruitshop.model.Fruit;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_COLUMN_NAME = "fruit";
    private static final String SECOND_COLUMN_NAME = "quantity";
    private static final String DELIMITER = ",";

    @Override
    public String generateReport(Set<Map.Entry<Fruit, BigDecimal>> report) {
        StringBuilder reportString = new StringBuilder(FIRST_COLUMN_NAME
                + DELIMITER + SECOND_COLUMN_NAME + System.lineSeparator());
        for (Map.Entry<Fruit, BigDecimal> mapEntry : report) {
            reportString.append(mapEntry.getKey().getFruitName())
                    .append(DELIMITER)
                    .append(mapEntry.getValue())
                    .append(System.lineSeparator());
        }
        return reportString.toString();
    }
}
