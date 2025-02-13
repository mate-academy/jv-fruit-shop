package core.basesyntax.report;

import static core.basesyntax.storage.FruitStorage.fruitStorage;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : fruitStorage.entrySet()) {
            report.append(fruit.getKey()).append(",").append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
