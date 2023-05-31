package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    public List<String> createReport() {
        List<String> reportData = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : Storage.STORAGE_MAP.entrySet()) {
            String line = entry.getKey() + "," + entry.getValue() + System.lineSeparator();
            reportData.add(line);
        }
        return reportData;
    }
}
