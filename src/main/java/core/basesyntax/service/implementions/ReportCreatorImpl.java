package core.basesyntax.service.implementions;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String TITLE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport(Map<Fruit, Integer> stockBalance) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.fruitStorage.entrySet()) {
            reportBuilder.append(entry.getKey().getName()).append(COMMA)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
