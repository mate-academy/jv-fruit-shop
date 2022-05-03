package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportMaker;
import java.util.Map;

public class ReportMakerImpl implements ReportMaker {
    private static final String FORMAT_OF_REPORT = "fruit, quantity";

    @Override
    public String createNewReport() {
        StringBuilder report = new StringBuilder();
        report.append(FORMAT_OF_REPORT + "\n");
        for (Map.Entry<Fruit, Integer> entry: Storage.store.entrySet()) {
            report.append(entry.getKey().getFruitName() + ", " + entry.getValue() + "\n");
        }
        return report.toString();
    }
}
