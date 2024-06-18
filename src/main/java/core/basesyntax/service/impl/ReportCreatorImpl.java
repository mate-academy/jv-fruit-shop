package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import java.util.ArrayList;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit, quantity";

    @Override
    public ArrayList<String> createReport(Map<String, Integer> transactions) {
        ArrayList<String> createReport = new ArrayList<>();
        createReport.add(HEADER);
        for (Map.Entry<String, Integer> entry : transactions.entrySet()) {
            createReport.add(entry.getKey() + "," + entry.getValue());
        }
        return createReport;
    }
}
