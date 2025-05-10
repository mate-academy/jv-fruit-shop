package core.basesyntax.serviseimpl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private final Map<String, Integer> fruitStore;

    public ReportGeneratorImpl(Map<String, Integer> fruitStore) {
        this.fruitStore = fruitStore;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append("\n");
        for (Map.Entry<String, Integer> entry : fruitStore.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}
