package core.basesyntax.report;

import static core.basesyntax.storage.FruitStorage.fruitStorage;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity").append(LINE_SEPARATOR);
        for (Map.Entry<String, Integer> fruit : fruitStorage.entrySet()) {
            report.append(fruit.getKey()).append(",").append(fruit.getValue())
                    .append(LINE_SEPARATOR);
        }
        return report.toString();
    }
}
