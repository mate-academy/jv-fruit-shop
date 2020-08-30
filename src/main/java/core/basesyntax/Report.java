package core.basesyntax;

import java.util.Set;

public class Report {
    private StringBuilder report = new StringBuilder("fruit,quantity");

    public String getReport() {
        Set<String> keys = ProductCalculator.STORAGE.keySet();
        String[] keysArray = keys.toArray(new String[0]);
        for (String s : keysArray) {
            int totalAmount = 0;
            for (int j = 0; j < ProductCalculator.STORAGE.get(s).size(); j++) {
                totalAmount = totalAmount + ProductCalculator.STORAGE.get(s).get(j).getQuantity();
            }
            report.append("\n").append(s).append(",").append(totalAmount);
        }
        return report.append("\n").toString();
    }
}
