package core.basesyntax.reportgenerator;

import core.basesyntax.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit, quantity\n");

        Map<String, Integer> fruits = storage.getFruits();

        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            String fruit = entry.getKey();
            Integer quantity = entry.getValue();
            report.append(String.format("%s,%d\n", fruit, quantity));
        }

        return report.toString();
    }
}
