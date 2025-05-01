package core.basesyntax.report;

import static core.basesyntax.storage.FruitStorage.fruitStorage;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FILE_HEADER = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(FILE_HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : fruitStorage.entrySet()) {
            report.append(fruit.getKey()).append(COMMA_SEPARATOR).append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
