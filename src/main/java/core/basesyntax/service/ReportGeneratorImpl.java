package core.basesyntax.service;

import java.util.HashMap;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private String report;
    private Map<String, Integer> inventory;

    public ReportGeneratorImpl() {
        this.inventory = new HashMap<>();
        this.report = "";
    }

    @Override
    public String getReport() {
        return this.report;
    }

    @Override
    public void generateReport(Map<String, Integer> inventory) {
        this.inventory = inventory;
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            reportBuilder.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        this.report = reportBuilder.toString();
    }
}
