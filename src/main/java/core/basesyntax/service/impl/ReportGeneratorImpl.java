package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Map<String, Integer> inventoryData) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : inventoryData.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
