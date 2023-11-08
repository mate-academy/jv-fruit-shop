package core.basesyntax.report;

import java.util.List;
import java.util.Map;

public interface ReportRecorder {
    List<String> getStorageData(Map<String, Integer> storageMap);
}
