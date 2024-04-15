package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String create() {
        StringBuilder report = new StringBuilder(TITLE);
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
