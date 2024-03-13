package core.basesyntax.service;

import core.basesyntax.model.TypeOfFruit;
import java.util.Map;

public class ReportContentImpl implements ReportContent {
    private static final String REPORT_HEADER = "fruit,quantity\n";

    @Override
    public String generateReportContent(Map<TypeOfFruit, Integer> fruitServiceMap) {
        StringBuilder reportContent = new StringBuilder();
        reportContent.append(REPORT_HEADER);
        for (Map.Entry<TypeOfFruit, Integer> entry : fruitServiceMap.entrySet()) {
            TypeOfFruit fruitType = entry.getKey();
            int quantity = entry.getValue();
            if (quantity < 0) {
                throw new RuntimeException("Balance is negative");
            }
            reportContent.append(String.valueOf(fruitType).toLowerCase())
                    .append(",")
                    .append(quantity)
                    .append("\n");
        }
        return reportContent.toString();
    }
}
