package core.basesyntax.service.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public List<String> report(Map<String, Integer> fruitStorage) {
        List<String> result = new ArrayList<>();
        result.add(HEADER);
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            result.add(entry.getKey() + DELIMITER + entry.getValue());
        }
        return result;
    }
}
