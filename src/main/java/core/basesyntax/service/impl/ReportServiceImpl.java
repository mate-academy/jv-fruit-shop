package core.basesyntax.service.impl;

import java.util.Map;

public class ReportServiceImpl implements ReportService {

    @Override
    public String generateReport(Map<String, Integer> fruitData) {
        StringBuilder builder = new StringBuilder("fruit,quantity\n");

        for (Map.Entry<String, Integer> entry : fruitData.entrySet()) {
            builder.append(entry.getKey() + "," + entry.getValue() + "\n");
        }

        return builder.toString();
    }
}
