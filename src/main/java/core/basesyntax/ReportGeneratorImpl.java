package core.basesyntax;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append("\n");
        Map<String, Integer> fruits = storage.getAllFruits();
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue())
                .append("\n");
        }
        return report.toString();
    }
}
