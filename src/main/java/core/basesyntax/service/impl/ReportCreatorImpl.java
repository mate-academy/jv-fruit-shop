package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String COMA = ",";
    private static final String REPORT_HEADLINE = "fruit,quantity";
    private static final String NEW_LINE = "\n";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_HEADLINE).append(NEW_LINE);
        for (Map.Entry<String, Integer> map : Storage.storage.entrySet()) {
            builder.append(map.getKey())
                    .append(COMA)
                    .append(map.getValue())
                    .append(NEW_LINE);
        }
        return builder.toString();
    }
}
