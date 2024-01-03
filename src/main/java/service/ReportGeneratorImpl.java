package service;

import dao.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FRUIT_QUANTITY_LABEL = "Fruit, Quantity";
    private static final String SEPARATOR = ", ";
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String generateReport(Map<String, Integer> fruitQuantities) {
        Map<String, Integer> fruitQuantitiesFromStorage = storage.getAllFruitsWithQuantity();

        StringBuilder report = new StringBuilder();
        report.append(FRUIT_QUANTITY_LABEL).append(System.lineSeparator());
        fruitQuantitiesFromStorage.forEach((fruit, quantity) -> report.append(fruit)
                .append(SEPARATOR)
                .append(quantity)
                .append(System.lineSeparator()));
        return report.toString();
    }
}
