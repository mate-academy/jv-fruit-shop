package core.basesyntax.reportgenerator;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit, quantity").append(System.lineSeparator());

        Map<String, Integer> fruits = storage.getFruits();

        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            String fruit = entry.getKey();
            Integer quantity = entry.getValue();
            report.append(String.format("%s,%d%s", fruit, quantity, System.lineSeparator()));
        }

        return report.toString();
    }
}
