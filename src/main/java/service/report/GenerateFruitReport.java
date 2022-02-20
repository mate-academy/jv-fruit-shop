package service.report;

import java.util.Map;
import storage.FruitStorage;

public class GenerateFruitReport implements GenerateReport {
    private static final String SEPARATOR = ",";

    @Override
    public StringBuilder generateResultForCommodity(String fruit, int amount) {
        StringBuilder generateLine = new StringBuilder();
        generateLine.append(fruit).append(SEPARATOR).append(amount);
        return generateLine;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry: FruitStorage.fruitStorage.entrySet()) {
            report.append(System.lineSeparator());
            report.append(generateResultForCommodity(entry.getKey(), entry.getValue()));
        }
        return new String(report);
    }
}
