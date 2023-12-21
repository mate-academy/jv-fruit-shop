package service;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generateReport(Map<String, Integer> fruitQuantities) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");
        fruitQuantities.forEach((fruit, quantity) -> report.append(fruit)
                .append(",")
                .append(quantity)
                .append("\n"));
        return report.toString();
    }
}
