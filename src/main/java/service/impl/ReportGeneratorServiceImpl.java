package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportGeneratorService;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String SEPARATOR = ",";
    private static final String HEADERS = "fruit,quantity\n";

    public ReportGeneratorServiceImpl() {
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADERS);

        Map<String, Integer> fruitBalance = Storage.getAllFruitBalances();

        for (Map.Entry<String, Integer> entry : fruitBalance.entrySet()) {
            String fruit = entry.getKey();
            int quantity = entry.getValue();
            report.append(fruit).append(SEPARATOR).append(quantity).append("\n");
        }
        return report.toString();
    }
}
