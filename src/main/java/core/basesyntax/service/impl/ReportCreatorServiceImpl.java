package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String TITLE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(TITLE);
        report.append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : Storage.fruits.entrySet()) {
            report.append(fruit.getKey()).append(COMMA)
                    .append(fruit.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
