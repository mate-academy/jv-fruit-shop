package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportCreationServiceImpl implements ReportCreationService {
    private static final String SEPARATOR = ",";

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.add(System.lineSeparator()
                    + entry.getKey()
                    + SEPARATOR
                    + entry.getValue());
        }
        return report;
    }
}
