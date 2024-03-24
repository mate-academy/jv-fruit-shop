package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreatorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.add(System.lineSeparator() + entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}
