package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String TITLE = "fruit,quantity";
    private static final int TITLE_INDEX = 0;
    private static final String DELIMITER = ",";

    @Override
    public List<String> getReport() {
        List<String> report = new ArrayList<>();
        report.add(TITLE_INDEX, TITLE);
        for (Map.Entry<String, Integer> lot : Storage.getStoredFruits().entrySet()) {
            report.add(lot.getKey() + DELIMITER + lot.getValue());
        }
        return report;
    }
}
