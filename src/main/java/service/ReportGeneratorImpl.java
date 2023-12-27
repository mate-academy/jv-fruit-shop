package service;

import db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String generateReport(Map<String, Integer> fruitQuantities) {
        Map<String, Integer> fruitQuantitiesFromStorage = storage.getAllFruitsWithQuantity();

        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");
        fruitQuantitiesFromStorage.forEach((fruit, quantity) -> report.append(fruit)
                .append(",")
                .append(quantity)
                .append("\n"));
        return report.toString();
    }
}
