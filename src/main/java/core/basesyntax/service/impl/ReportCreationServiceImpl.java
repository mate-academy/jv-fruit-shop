package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportCreationServiceImpl implements ReportCreationService {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.add(entry.getKey()
                    + SEPARATOR
                    + entry.getValue()
                    + System.lineSeparator());
        }
        return report;
    }
}
