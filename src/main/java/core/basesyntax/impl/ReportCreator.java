package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportPreparer;
import java.util.Map;

public class ReportCreator implements ReportPreparer {
    private static final String REPORT_FRUIT = "fruit";
    private static final String COMMA = ",";
    private static final String REPORT_QUANTITY = "fruit";
    private static final String LINE = System.lineSeparator();

    public String prepare() {
        StringBuilder preparedForWrite = new StringBuilder()
                .append(REPORT_FRUIT)
                .append(COMMA)
                .append(REPORT_QUANTITY);
        for (Map.Entry<String, Integer> data : Storage.getStorage().entrySet()) {
            preparedForWrite.append(LINE).append(data.getKey())
                    .append(COMMA).append(data.getValue());
        }
        return preparedForWrite.toString();
    }
}
