package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGeneratorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public List<String> generateReport() {
        List<String> report = new ArrayList<>();
        report.add(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.STORAGE.entrySet()) {
            report.add(entry.getKey() + DELIMITER + entry.getValue());
        }
        return report;
    }
}
