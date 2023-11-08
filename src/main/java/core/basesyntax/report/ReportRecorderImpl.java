package core.basesyntax.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportRecorderImpl implements ReportRecorder {
    @Override
    public List<String> getStorageData(Map<String, Integer> storageMap) {
        List<String> reportList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : storageMap.entrySet()) {
            reportList.add(String.valueOf(entry));
            reportList.add(System.lineSeparator());
        }
        return reportList;
    }
}
