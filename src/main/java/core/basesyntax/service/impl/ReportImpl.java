package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Report;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportImpl implements Report {
    private static final String REPORT_TITLE = "fruit,quantity";

    @Override
    public List<String> createNewReport() {
        List<String> dailyReport = new ArrayList<>();
        dailyReport.add(REPORT_TITLE);
        for (Map.Entry<Fruit, Integer> entry: Storage.storage.entrySet()) {
            String reportValue = entry.getKey().getFruitName() + ", " + entry.getValue();
            dailyReport.add(reportValue);
        }
        return dailyReport;
    }
}
