package service;

import db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FRUIT_QUANTITY_LABEL = "fruitQuantity";
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String generateReport(Map<String, Integer> fruitQuantities) {
        Map<String, Integer> fruitQuantitiesFromStorage = storage.getAllFruitsWithQuantity();

        StringBuilder report = new StringBuilder();
        report.append(FRUIT_QUANTITY_LABEL + System.lineSeparator());
        fruitQuantitiesFromStorage.forEach((fruit, quantity) -> report.append(fruit)
                .append(", ")
                .append(quantity)
                .append(System.lineSeparator()));
        return report.toString();
    }
}
