package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportMaker;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportMakerImpl implements ReportMaker {
    private static final String FORMAT_OF_REPORT = "fruit, quantity";

    @Override
    public List<String> createNewReport() {
        List<String> report = new ArrayList<>();
        report.add(FORMAT_OF_REPORT);
        for (Map.Entry<Fruit, Integer> entry: Storage.store.entrySet()) {
            String reportValue = entry.getKey().getFruitName() + ", " + entry.getValue();
            report.add(reportValue);
        }
        return report;
    }
}
