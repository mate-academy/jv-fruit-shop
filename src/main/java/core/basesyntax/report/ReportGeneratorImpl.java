package core.basesyntax.report;

import static core.basesyntax.storage.FruitStorage.fruitStorage;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String FILE_HEADER = "fruit,quantity";
    private static final String COMA_SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(FILE_HEADER).append(LINE_SEPARATOR);
        for (Map.Entry<String, Integer> fruit : fruitStorage.entrySet()) {
            report.append(fruit.getKey()).append(COMA_SEPARATOR).append(fruit.getValue())
                    .append(LINE_SEPARATOR);
        }
        return report.toString();
    }
}
