package core.basesyntax;

import core.basesyntax.CreateReport;

import java.util.Map;

public class CreateReportImpl implements CreateReport {
    @Override
    public String writeReport(Map<String, Integer> resume) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity \n");
        for (Map.Entry<String, Integer> entry : resume.entrySet()) {
            String fruit = entry.getKey();
            int amount = entry.getValue();
            stringBuilder.append(fruit).append(",").append(amount).append("\n");
        }
        return stringBuilder.toString();
    }
}
