package core.basesyntax.reportservice;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FRUIT_COLUMN_TITLE = "fruit";
    private static final String QUANTITY_COLUMN_TITLE = "quantity";
    private static final String DELIMITER = ",";

    @Override
    public String createReport(Map<Fruit, Integer> fruitMap) {
        StringBuilder builder = new StringBuilder();
        builder.append(FRUIT_COLUMN_TITLE)
                .append(DELIMITER)
                .append(QUANTITY_COLUMN_TITLE)
                .append(System.lineSeparator());

        for (Map.Entry<Fruit, Integer> entry : fruitMap.entrySet()) {
            builder.append(entry.getKey().getName())
                    .append(DELIMITER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
