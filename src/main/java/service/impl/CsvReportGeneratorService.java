package service.impl;

import db.ShopStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.ReportGeneratorService;

public class CsvReportGeneratorService implements ReportGeneratorService {
    private final ShopStorage fruitStorage;

    public CsvReportGeneratorService(ShopStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    public List<String> generateReport() {
        List<String> report = new ArrayList<>();
        report.add("fruit,quantity");

        for (Map.Entry<String, Integer> entry : fruitStorage.getFruitQuantities().entrySet()) {
            String line = entry.getKey() + "," + entry.getValue();
            report.add(line);
        }
        return report;
    }
}
