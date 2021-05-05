package core.basesyntax.service.implementions;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String TITLE_ROW = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String createReport(Map<Fruit, Integer> stockBalance) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE_ROW).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.fruitStorage.entrySet()) {
            reportBuilder.append(entry.getKey().getName()).append(CSV_SEPARATOR)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
