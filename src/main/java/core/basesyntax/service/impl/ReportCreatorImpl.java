package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADLINE = "fruit,quantity";
    private static final int HEADLINE_INDEX = 0;
    private static final int FIRST_LINE_REPORT = 1;

    @Override
    public String[] getReport() {
        String[] report = new String[Storage.fruits.size() + 1];
        report[HEADLINE_INDEX] = HEADLINE;
        int counter = FIRST_LINE_REPORT;
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            report[counter++] = entry.getKey() + "," + entry.getValue();
        }
        return report;
    }
}
