package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportMaker;
import java.util.Map;

public class ReportMakerImpl implements ReportMaker {
    private static final String REPORT_TABLE_COLUMNS = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder result = new StringBuilder(REPORT_TABLE_COLUMNS);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            result.append(System.lineSeparator()).append(entry.getKey())
                    .append(SEPARATOR).append(entry.getValue());
        }
        return result.toString();
    }
}
