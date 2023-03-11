package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Report;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportImpl implements Report {
    private static final String TITLE = "fruit,quantity";

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add(TITLE);
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            String reportString = entry.getKey().getFruitName()
                    + "," + entry.getValue();
            report.add(reportString);
        }
        return report;
    }
}
