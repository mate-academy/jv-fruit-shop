package core.basesyntax;

import java.util.Map;

public class ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final FruitStock fruitStock;

    public ReportGenerator(FruitStock fruitStock) {
        this.fruitStock = fruitStock;
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : fruitStock.getAll().entrySet()) {
            report.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return report.toString();
    }
}
