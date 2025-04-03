package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportGenerator {

    public String generateReport(List<FruitTransaction> transactions) {
        Map<String, Integer> report = new HashMap<>();

        for (FruitTransaction transaction : transactions) {
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();

            switch (transaction.getOperation()) {
                case SUPPLY:
                    report.put(fruit, report.getOrDefault(fruit, 0) + quantity);
                    break;
                case PURCHASE:
                    report.put(fruit, report.getOrDefault(fruit, 0) - quantity);
                    break;
                case RETURN:
                    report.put(fruit, report.getOrDefault(fruit, 0) + quantity);
                    break;
                case BALANCE:
                    break;
                default:
                    System.out.println("Невідома операція: " + transaction.getOperation());
            }
        }

        StringBuilder reportOutput = new StringBuilder();
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            reportOutput.append(entry.getKey())
                        .append(": ")
                        .append(entry.getValue())
                        .append("\n");
        }

        return reportOutput.toString();
    }
}

