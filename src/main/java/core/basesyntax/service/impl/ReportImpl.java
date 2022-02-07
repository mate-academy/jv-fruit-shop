package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Report;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportImpl implements Report {
    private static final String REPORT_NAME = "Fruit, Amount";

    @Override
    public List<String> createNewReport() {
        List<String> report = new ArrayList<>();
        report.add(REPORT_NAME);
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            String reportValue = entry.getKey().getFruitName() + ", " + entry.getValue();
            report.add(reportValue);
        }
        return report;
    }
}
