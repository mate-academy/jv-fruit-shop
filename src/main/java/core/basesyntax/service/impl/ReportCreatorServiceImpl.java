package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreatorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public List<String> getReport() {
        List<String> report = new ArrayList<>();
        report.add(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.add("\n" + entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}
