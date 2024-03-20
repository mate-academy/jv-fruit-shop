package core.basesyntax.service.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public List<String> generate(Map<String, Integer> fruitQuantity) {
        List<String> result = new ArrayList<>();
        result.add(HEADER);
        for (Map.Entry<String, Integer> entry : fruitQuantity.entrySet()) {
            String line = entry.getKey() + DELIMITER + entry.getValue();
            result.add(line);
        }
        return result;
    }
}
