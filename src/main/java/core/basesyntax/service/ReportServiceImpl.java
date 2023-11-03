package core.basesyntax.service;

import static core.basesyntax.db.Storage.reportData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public List<String> createReport() {
        List<String> reportList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : reportData.entrySet()) {
            reportList.add(entry.getKey() + ", " + entry.getValue());
        }
        return reportList;
    }
}
