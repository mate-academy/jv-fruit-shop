package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportGeneratorService;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private final Storage storage;

    public ReportGeneratorServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");

        Map<String, Integer> fruitBalance = storage.getAllFruitBalances();

        for (Map.Entry<String, Integer> entry : fruitBalance.entrySet()) {
            String fruit = entry.getKey();
            int quantity = entry.getValue();
            report.append(fruit).append(",").append(quantity).append("\n");
        }
        return report.toString();
    }
}
